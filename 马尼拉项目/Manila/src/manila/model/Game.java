package manila.model;

import java.util.ArrayList;
import java.util.Random;

import manila.view.GameView;

/**
 * 游戏类
 * @author Zuo
 */
public class Game {
	
	/**
	 * 表示当前游戏某一轮某一回合的某一阶段
	 * 1 - 玩家选择阶段
	 * 2 - 移动船只
	 */
	private int stage;
	
	/**
	 * 表示当前游戏是否结束
	 * false - 游戏尚未结束
	 * true - 游戏结束
	 */
	private boolean gameOver;
	/**
	 * 航程，表示游戏为第几轮
	 */
	private int voyage;
	/**
	 * 表示游戏为当前航程下第几回合
	 */
	private int round;
	/**
	 * 当前玩家id,对应玩家数组下标
	 */
	private int current_playerId;
	/**
	 * 表示队长（管理人）ID,对应玩家数组下标
	 */
	private int captainID;
	
	private int setnum;
	
	/**
	 * 色子（骰子），随机数类实现
	 */
	private Random dice;
	/**
	 * 玩家实现数组
	 */
	private ArrayList<Player> players;
	/**
	 * 银行实现
	 */
	private Bank bank;
	/**
	 * 黑市实现
	 */
	private BlackMarket black_market;
	/**
	 * 地图实现
	 */
	private Map map;
	
	private GameView game_view;
	
	/**
	 * @param gameScale 游戏规模，即游戏中有几名玩家
	 */
	public Game(int gameScale, GameView gv) {
		//初始化玩家数组
		this.players = new ArrayList<Player>();
		for(int i = 0; i < gameScale; i++) {
			Player newplayer = new Player(i, gameScale);
			this.players.add(newplayer);
		}
		
		//初始化非基本类
		this.bank = new Bank();
		this.black_market = new BlackMarket();
		this.map = new Map();
		this.dice = new Random();
		this.game_view = gv;
		this.setnum = 0;
		
		//基本变量初始化
		this.stage = 0;
		this.gameOver = false;
		this.voyage = 1;
		this.round = 1;
		this.current_playerId = 0;
		this.captainID = 0;
		
		for(int i = 0; i < this.players.size(); i++) {
			this.players.get(i).foreLoadingStocks(this.black_market);
		}
	}


	/**
	 * 每一航程开始前，初始化部分内容
	 */
	public void preparation() {
		this.voyage++;
		this.round = 1;
		this.map.reSet();
		stage = 0;
		setnum = 0;
		for(Player p: this.players) {
			p.setAvail_employee(3);
		}
	}
	
	/**
	 * 每一航程开始由负责人选择了装载的货物及顺序，按航道一至三的顺序依次将货物上船;
	 * 货物id参见黑市注释;
	 * @param id1 第一航道的货物id
	 * @param id2 第二航道的货物id
	 * @param id3 第三航道的货物id
	 */
	public void loadCargo(int id1, int id2, int id3) {
		this.map.loadCargo(id1, id2, id3);
	}
	
	/**
	 * 每一航程开始由负责人决定各船的初始位置，要求任一一只船初始位置不大于5且不小于0，且三只船初始位置总和为9；
	 * @param step1 第一航道船只的初始位置
	 * @param step2 第二航道船只的初始位置
	 * @param step3 第三航道船只的初始位置
	 * @return 设置是否生效
	 */
	public boolean setStartingPoint(int step1, int step2, int step3) {
		if(this.map.setStartingPoint(step1, step2, step3)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 切换玩家，按数组下标顺序切换
	 */
	public void switchPlayer() {
		this.current_playerId = (this.current_playerId + 1)%this.players.size();
	}
	
	/**
	 * 当前玩家选择上船
	 * @param boatId 选定的船
	 * @return 是否上船，上船成功返回ture，否则为false
	 */
	public boolean getOnboard(int boatId) {
		if(this.map.getBoats().get(boatId).getOnboard(this.current_playerId)) {
			if(this.players.get(this.current_playerId).payForPosition(this.map.getBoats().get(boatId).getPosPrice())) {
				this.bank.gainMoney(this.map.getBoats().get(boatId).getPosPrice());
				return true;
			}else {
				//if(this.players.get(this.current_playerId).getAvail_employee() < 1)
				this.map.resetPosPid(0,boatId);
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 当前在指定位置放置同伙
	 * @param posType 位置的种类；规定：0-船只；1-码头；2-修船厂；3-领航员；4-海盗；5-保险人；
	 * @param posId 位置的id，对应相应的位置种类在map中的数组下标
	 * @return 成功放置为true，否则为false；
	 */
	public boolean setEmployee(int posType, int posId) {
		switch(posType) {
		case 0: 
			if(this.getOnboard(posId)) {
				setnum++;
				return true;
			}
			return false;
		case 1:
		case 2:
		case 3:
		case 5:
			if(this.map.setPosPid(posType, posId, this.current_playerId)) {
				if(this.players.get(this.current_playerId).payForPosition(this.map.getPosPrice(posType, posId))) {
					this.bank.gainMoney(this.map.getPosPrice(posType, posId));
					setnum++;
					return true;
				}else {
					this.map.resetPosPid(posType, posId);
				}
				return false;
			}
		case 4:
			switch(posId) {
			case 0:
				if(this.map.getPirates()[0].getplayer_id() == -1) {
					if(this.players.get(this.current_playerId).payForPosition(this.map.getPirates()[0].getPrice())) {
						this.map.setPosPid(posType, posId, this.current_playerId);
						setnum++;
						return true;
					}else {
						System.out.println(this.getMap().getBoats().get(0).getPos_list().get(0).getplayer_id());
						return false;
					}
				}else {
					if(this.players.get(this.current_playerId).payForPosition(this.map.getPirates()[1].getPrice())) {
						this.map.setPosPid(posType, posId + 1, this.current_playerId);
						setnum++;
						return true;
					}else {
						return false;
					}
				}
			case 1:
				if(this.map.getPirates()[0].getplayer_id() == -1) {
					if(this.players.get(this.current_playerId).payForPosition(this.map.getPirates()[0].getPrice())) {
						this.map.setPosPid(posType, posId - 1, this.current_playerId);
						setnum++;
						return true;
					}else {
						return false;
					}
				}else {
					if(this.players.get(this.current_playerId).payForPosition(this.map.getPirates()[1].getPrice())) {
						this.map.setPosPid(posType, posId, this.current_playerId);
						setnum++;
						return true;
					}else {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	public int getSetnum() {
		return setnum;
	}


	public void setSetnum(int setnum) {
		this.setnum = setnum;
	}


	/**
	 *模拟掷骰子
	 * @return 1至6随机数
	 */
	public int rollDice() {
		return this.dice.nextInt(5) + 1;
	}
	
	/**
	 * 调用三次moveBoat方法，顺序移动所有船只，并在移动完后回合数加一；
	 */
	public void moveBoats() {
		if(this.round < 4) {
			this.round++;
			this.moveBoat(0);
			this.moveBoat(1);
			this.moveBoat(2);
		}
	}
	
	/**
	 * 调用map中移动船只的函数，将指定的船只移动随机格数；若这一航程已结束（第三回合完结），那么抵达港口的货物升值，未抵达港口的，状态变更为失事
	 * @param boatId - 指定的船只id, 对应map中船只数组相应下标
	 */
	public void moveBoat(int boatId) {
		this.map.moveBoat(this.rollDice(), boatId);
		if(round == 4 && this.map.getBoats().get(boatId).entered()) {
			this.black_market.riseInPrice(this.map.getBoats().get(boatId).getBoatID());
		}
		if(round == 4 && this.map.getBoats().get(boatId).getPos_in_the_sea() <= 13) {
			this.map.getBoats().get(boatId).setState(0);
		}
	}
	
	/**
	 * 将船移动固定位置函数，若这一航程已结束（第三回合完结），那么抵达港口的货物升值，未抵达港口的，状态变更为失事
	 * @param boatId 被指定移动的船只的id
	 * @param step 指定的步数
	 */
	public void moveBoatByConstant(int boatId, int step) {
		this.map.moveBoat(step, boatId);
		if(round == 4 && this.map.getBoats().get(boatId).entered()) {
			this.black_market.riseInPrice(this.map.getBoats().get(boatId).getBoatID());
		}
		if(round == 4 && this.map.getBoats().get(boatId).getPos_in_the_sea() <= 13) {
			this.map.getBoats().get(boatId).setState(0);
		}
	}
	
	/**
	 * 每回合游戏（一个航程内）结束后开始结算利润
	 */
	public void distributeProfit() {
		this.map.distributeProfit(this.players, this.bank);
	}
	
	/**
	 * 检验是否结束游戏；结束条件：黑市中某一货物价格达到30；结束后将游戏gameOver更改为true
	 * @return 若游戏结束，返回胜者id，对应数组下标；否则，返回-1
	 */
	public int checkWin() {
		if(this.black_market.reachThirty()) {
			int winner_id = 0;
			for(int i = 1; i < this.players.size(); i++) {
				if(this.players.get(i).getProperty(this.black_market) > this.players.get(i-1).getProperty(this.black_market)) {
					winner_id = i;
				}
			}
			this.gameOver = true;
			return winner_id;
		}
		return -1;
	}
	
	/**
	 * 使海盗船长（0号海盗位置上的海盗）登上指定的船只，并决定船的命运
	 * @param boatId 指定船只的ID，对应数组下标
	 * @param enter 若为true，使船只进港，false则使之失事
	 * @return 是否掠夺成功
	 */
	public boolean robBoatById(int boatId, boolean enter) {
		if(this.map.getPirates()[0].getplayer_id() != -1) {
			this.map.getPirates()[0].rob(this.map.getBoats().get(boatId), enter);
			return true;
		}
		return false;
	}
	
	/**
	 * 海盗登船函数
	 * @param boatId 被登上的船
	 * @return 登船是否成功
	 */
	public boolean pirateAboard(int boatId) {
		if(this.map.getPirates()[0].getplayer_id() != -1) {
			if(this.map.getPirates()[0].getOnBoard(this.map.getBoats().get(boatId))) {
				if(this.map.getPirates()[1].getplayer_id() != -1) {
					this.map.getPirates()[0].setplayer_id(this.map.getPirates()[1].getplayer_id());
					this.map.getPirates()[1].setplayer_id(-1);
				}
				return true;
			}
		}
		return false;
	}
	
	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public int getVoyage() {
		return voyage;
	}

	public void setVoyage(int voyage) {
		this.voyage = voyage;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getCurrent_playerId() {
		return current_playerId;
	}

	public void setCurrent_playerId(int current_playerId) {
		this.current_playerId = current_playerId;
	}

	public int getCaptainID() {
		return captainID;
	}

	public void setCaptainID(int captainID) {
		this.captainID = captainID;
	}

	public Random getDice() {
		return dice;
	}

	public void setDice(Random dice) {
		this.dice = dice;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * 当玩家数小于5，添加一个玩家并返回“true"；
	 * 当玩家数为5时，返回“false",添加失败
	 */
	public boolean addPlayer() {
		if(this.players.size() < 5) {
			Player newplayer = new Player(this.players.size(), this.players.size()+1);
			this.players.add(newplayer);
			return true;
		}	
		return false;
	}
	
	/**
	 * 当玩家数大于3时，移除最后一个玩家并返回“true"；
	 * 当玩家数为3时，返回“false",移除失败
	 */
	public boolean removePlayer() {
		if(this.players.size() > 3) {
			this.players.remove(this.players.size() - 1);
			return true;
		}
		return false;
	}
	
	/**
	 * @param id - 需要获得的player的id
	 * @return 通过这个id找到的player
	 */
	public Player getPlayerById(int id) {
		return this.players.get(id);
	}
	
	/**
	 * @return 当前玩家（Player类）
	 */
	public Player getCurrentPlayer() {
		return this.players.get(this.current_playerId);
	}
	
	/**
	 * @return 队长（负责人）玩家(Player类）
	 */
	public Player getCapatainPlayer() {
		return this.players.get(this.captainID);
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BlackMarket getBlack_market() {
		return black_market;
	}

	public void setBlack_market(BlackMarket black_market) {
		this.black_market = black_market;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}


	
	public GameView getGame_view() {
		return game_view;
	}


	
	public void setGame_view(GameView game_view) {
		this.game_view = game_view;
	}
	
	
}
