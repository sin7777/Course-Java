package manila.model;

import java.util.ArrayList;

/**
 * 地图类
 * @author Zuo
 */
public class Map {
	
	/**
	 * 动态船，针对每个航程负责人选择装载的货物，是每个航程游戏中行进的船只
	 */
	private ArrayList<Boat> boats;
	
	/**
	 * 码头数组
	 */
	private Dock[] docks;
	/**
	 * 修船厂
	 */
	private Shipyard[] shipyards;
	/**
	 * 领航员
	 */
	private Navigator[] navigators;
	/**
	 * 海盗
	 */
	private Pirate[] pirates;
	/**
	 * 保险人
	 */
	private Insurer insurer;
	
	public Map() {
		
		//初始化码头位置
		this.docks = new Dock[3];
		Dock dock1 = new Dock(4,6);
		Dock dock2 = new Dock(3,8);
		Dock dock3 = new Dock(2,15);
		this.docks[0] = dock1;
		this.docks[1] = dock2;
		this.docks[2] = dock3;
		
		//初始化造船厂位置
		this.shipyards = new Shipyard[3];
		Shipyard shipyard1 = new Shipyard(4,6);
		Shipyard shipyard2 = new Shipyard(3,8);
		Shipyard shipyard3 = new Shipyard(2,15);
		this.shipyards[0] = shipyard1;
		this.shipyards[1] = shipyard2;
		this.shipyards[2] = shipyard3;
		
		//初始化领航员位置
		this.navigators = new Navigator[2];
		Navigator navigator1 = new Navigator(5);
		Navigator navigator2 = new Navigator(2);
		this.navigators[0] = navigator1;
		this.navigators[1] = navigator2;
		
		//初始化海盗位置
		this.pirates = new Pirate[2];
		Pirate pirate1 = new Pirate(5);
		Pirate pirate2 = new Pirate(5);
		this.pirates[0] = pirate1;
		this.pirates[1] = pirate2;
		
		//初始化保险人
		this.insurer = new Insurer(-10);
	}

	/**
	 * 每一轮游戏开始前将各个位置初始化，清空已被玩家占据的位置
	 */
	public void reSet() {
		this.docks[0].setplayer_id(-1);
		this.docks[1].setplayer_id(-1);
		this.docks[2].setplayer_id(-1);
		this.shipyards[0].setplayer_id(-1);
		this.shipyards[1].setplayer_id(-1);
		this.shipyards[2].setplayer_id(-1);
		this.navigators[0].setplayer_id(-1);
		this.navigators[1].setplayer_id(-1);
		this.pirates[0].setplayer_id(-1);
		this.pirates[1].setplayer_id(-1);
		this.insurer.setplayer_id(-1);
	}
	
	/**
	 * 每一航程开始由负责人选择了装载的货物及顺序，按航道一至三的顺序依次将货物上船;
	 * 货物id参见黑市注释;
	 * 此函数被Game类中的loadCargo方法所使用
	 * @param id1 第一航道的货物id
	 * @param id2 第二航道的货物id
	 * @param id3 第三航道的货物id
	 */
	public void loadCargo(int id1, int id2, int id3) {
		this.boats = new ArrayList<Boat>(3);
		this.boats.add(new Boat(id1));
		this.boats.add(new Boat(id2));
		this.boats.add(new Boat(id3));
		this.boats.get(0).setState(1);
		this.boats.get(1).setState(1);
		this.boats.get(2).setState(1);
	}
	
	/**
	 * 每一航程开始由负责人决定各船的初始位置
	 * 次函数被Game类中的setSartingPoint方法所调用
	 * @param step1 第一航道船只的初始位置
	 * @param step2 第二航道船只的初始位置
	 * @param step3 第三航道船只的初始位置
	 * @return 设置是否生效
	 */
	public boolean setStartingPoint(int step1, int step2, int step3) {
		if(step1 + step2 + step3 == 9 && step1<6 && step2<6 && step3<6 && step1 >=0 && step2 >=0 && step3>=0) {
			this.boats.get(0).setPos_in_the_sea(step1);
			this.boats.get(1).setPos_in_the_sea(step2);
			this.boats.get(2).setPos_in_the_sea(step3);
			return true;
		}
		return false;
	}
	
	/**
	 * 移动船只，被Game类中moveBoat方法调用
	 * @param rollDice 由Game中随机数模拟的移动点数
	 * @param boatId 被移动的船的id，对应数组下标
	 */
	public void moveBoat(int rollDice, int boatId) {
		this.boats.get(boatId).move(rollDice);
	}
	
	/**
	 * 此函数被Game类中distributeProfit函数调用，每回合游戏（一个航程）结束后，开始计算利润
	 * @param players 众玩家，用于分配利益
	 * @param bank 即Game中的银行
	 */
	public void distributeProfit(ArrayList<Player> players, Bank bank) {
		int wrecked_num = 0;
		int entered_num = 0;
		//遍历各船只
		for(Boat b:this.boats) {
			//如果船进入港口
			if(b.entered()) {
				entered_num++;
				int sailor_num = 0;
				//检测船上有几名水手
				for(Sailor s1: b.getPos_list()) {
					if(s1.getplayer_id() >=0 ) {
						sailor_num++;
					}
				}
				//为每名水手的主子平均分配利润
				for(Sailor s2: b.getPos_list()) {
					if(s2.getplayer_id() != -1) {
						players.get(s2.getplayer_id()).gainMoney(b.getValue()/sailor_num);
						bank.pay(b.getValue()/sailor_num);
					}
				}
			}else if(b.wrecked()) {
				wrecked_num++;
			}
		}
		for(int i = 0; i < wrecked_num; i++) {
			//如果有人买下了符合沉船数的序号的修船厂
			if(this.shipyards[i].getplayer_id() != -1) {
				players.get(this.shipyards[i].getplayer_id()).gainMoney(this.shipyards[i].getprofit());
				}
			//如果有保险人
			if(this.insurer.getplayer_id() != -1) {
				//如果保险人余额足够支持赔偿
				if(players.get(this.insurer.getplayer_id()).getBalance() > this.shipyards[i].getprofit()) {
					players.get(this.insurer.getplayer_id()).pay(this.shipyards[i].getprofit());
					System.out.println("保险人员赔偿了" + String.valueOf(this.shipyards[i].getprofit()) + "元");
				}else {
					//如果保险人余额不足且手中有股票，进行抵押
					while(players.get(this.insurer.getplayer_id()).getStocks().size() > 0 && players.get(this.insurer.getplayer_id()).getBalance() < this.shipyards[i].getprofit()) {
						players.get(this.insurer.getplayer_id()).loan(bank);
					}
					//完成强制抵押后，若余额足够了
					if(players.get(this.insurer.getplayer_id()).getBalance() > this.shipyards[i].getprofit()) {
						players.get(this.insurer.getplayer_id()).pay(this.shipyards[i].getprofit());
						System.out.println("保险人员赔偿了" + String.valueOf(this.shipyards[i].getprofit()) + "元");
					}else {
						//余额仍然不足，支付所有持有资金
						players.get(this.insurer.getplayer_id()).setBalance(0);
						System.out.println("保险人员赔光了");
					}
				}
				
			}
		}
        for(int i = 0; i < entered_num; i++) {
        	if(this.docks[i].getplayer_id() != -1) {
				players.get(this.docks[i].getplayer_id()).gainMoney(this.docks[i].getprofit());
			}
		}
		
	}

	/**
	 * 在Game类中setEmployee方法中被用于设置指定位置的玩家id
	 * @param posType 位置种类，详见Game类setEmployee方法
	 * @param posId 位置id，对应其数组下标
	 * @param pId 玩家id
	 * @return 设置成功为true
	 */
	public boolean setPosPid(int posType, int posId, int pId) {
		switch(posType) {
		case 1:
			if(this.docks[posId].getplayer_id() == -1) {
				this.docks[posId].setplayer_id(pId);
				return true;
			}
			return false;
		case 2:
			if(this.shipyards[posId].getplayer_id() == -1) {
				this.shipyards[posId].setplayer_id(pId);
				return true;
			}	
			return false;
		case 3:
			if(this.navigators[posId].getplayer_id() == -1) {
				this.navigators[posId].setplayer_id(pId);
				return true;
			}	
			return false;
		case 4:
			if(this.pirates[posId].getplayer_id() == -1) {
				this.pirates[posId].setplayer_id(pId);
				return true;
			}	
			return false;
		case 5:
			if(this.insurer.getplayer_id() == -1) {
				this.insurer.setplayer_id(pId);
				return true;
			}			
		}
		return false;
	}
	
	/**
	 * 重置指定的位置的玩家id，此方法被Game类中setEmployee即getOnboard使用，用于在玩家选定位置后发现付钱失败而用于取消该位置的玩家
	 * @param posType 位置种类，详见Game类setEmployee方法
	 * @param posId 位置id，对应其数组下标
	 */
	public void resetPosPid(int posType, int posId) {
		switch(posType) {
		case 0: if(this.boats.get(posId).getAvailPosIndex() != -1){
			this.boats.get(posId).getPos_list().get(this.boats.get(posId).getAvailPosIndex() - 1).setplayer_id(-1);break;
		}				
		case 1: this.docks[posId].setplayer_id(-1);break;
		case 2: this.shipyards[posId].setplayer_id(-1);break;
		case 3: this.navigators[posId].setplayer_id(-1);break;
		case 4: this.pirates[posId].setplayer_id(-1);break;
		case 5: this.insurer.setplayer_id(-1);break;
		}
	}
	
	/**
	 * 在Game类中setEmployee方法中被用于获得指定位置的价格
	 * @param posType 位置种类，详见Game类中setEmployee方法
	 * @param posId 位置id，对应其数组下标
	 * @return 指定位置所需价格
	 */
	public int getPosPrice(int posType, int posId) {
		switch(posType) {
		case 1:return this.docks[posId].getPrice();
		case 2:return this.shipyards[posId].getPrice();
		case 3:return this.navigators[posId].getPrice();
		case 4:	return this.pirates[posId].getPrice();
		case 5:return this.insurer.getPrice();
					
		}
		return 0;
	}
	
	/**
	 * @return 获取当前未被占据且价格最低的位置的价格
	 */
	public int getCheapestPosPrice() {
		int price = 10;
		for(Boat b: this.boats) {
			for(Sailor s:b.getPos_list()) {
				if(s.getplayer_id() == -1 && s.getPrice() < price)
					price = s.getPrice();
			}
		}
		for(Dock d:this.docks) {
			if(d.getplayer_id() == -1 && d.getPrice() < price)
				price = d.getPrice();
		}
		for(Shipyard sy:this.shipyards) {
			if(sy.getplayer_id() == -1 && sy.getPrice()<price) 
				price = sy.getPrice();
		}
		for(Navigator n:this.navigators) {
			if(n.getplayer_id() == -1 && n.getPrice() < price)
				price = n.getPrice();
		}
		for(Pirate p:this.pirates) {
			if(p.getplayer_id() == -1 && p.getPrice() < price)
				price = p.getPrice();
		}
		if(this.insurer.getplayer_id() == -1 && this.insurer.getPrice() < price)
			price = this.insurer.getPrice();
		return price;
	}
	
	public ArrayList<Boat> getBoats() {
		return boats;
	}

	public void setBoats(ArrayList<Boat> boats) {
		this.boats = boats;
	}

	public Dock[] getDocks() {
		return docks;
	}

	public void setDocks(Dock[] docks) {
		this.docks = docks;
	}

	public Shipyard[] getShipyards() {
		return shipyards;
	}

	public void setShipyards(Shipyard[] shipyards) {
		this.shipyards = shipyards;
	}

	public Navigator[] getNavigators() {
		return navigators;
	}

	public void setNavigators(Navigator[] navigators) {
		this.navigators = navigators;
	}

	public Pirate[] getPirates() {
		return pirates;
	}

	public void setPirates(Pirate[] pirates) {
		this.pirates = pirates;
	}
	
}
