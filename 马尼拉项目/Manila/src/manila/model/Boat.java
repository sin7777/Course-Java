package manila.model;

import java.util.ArrayList;

//import manila.view.PlaygroundView;

public class Boat {
	/**货物的id*/
	int boatID;
	/**船上装载的货物*/
	String cargoName;
	/**处于什么阶段，沉船或是在海上或是抵达港口
	 *-1 - 未出海
	 *0 - 沉船
	 *1 - 海上行驶
	 *2 - 抵达港口
	 */
	int state;
	/** 船上的空位数组 */
	private ArrayList<Sailor> pos_list;
	/**船在海中的位置*/
	int pos_in_the_sea;
	/**船上货物的价值*/
	int value;
	
	
	public Boat(int cargoId)
	{
		this.state = -1;
		
		Sailor sailor;
		switch(cargoId) {
		case 1: 
			this.boatID = 1;
			this.cargoName = "肉豆蔻";
			this.value = 24;
			this.pos_list = new ArrayList<Sailor>();
			sailor = new Sailor(2);
			this.pos_list.add(sailor);
			sailor = new Sailor(3);
			this.pos_list.add(sailor);
			sailor = new Sailor(4);
			this.pos_list.add(sailor);
			break;
		case 2:
			this.boatID = 2;
			this.cargoName = "丝绸";
			this.value = 30;
			this.pos_list = new ArrayList<Sailor>();
			sailor = new Sailor(3);
			this.pos_list.add(sailor);
			sailor = new Sailor(4);
			this.pos_list.add(sailor);
			sailor = new Sailor(5);
			this.pos_list.add(sailor);
			break;
		case 3:
			this.boatID = 3;
			this.cargoName = "人参";
			this.value = 18;
			this.pos_list = new ArrayList<Sailor>();
			sailor = new Sailor(1);
			this.pos_list.add(sailor);
			sailor = new Sailor(2);
			this.pos_list.add(sailor);
			sailor = new Sailor(3);
			this.pos_list.add(sailor);
			break;
		case 4:
			this.boatID = 4;
			this.cargoName = "玉石";
			this.value = 36;
			this.pos_list = new ArrayList<Sailor>();
			sailor = new Sailor(3);
			this.pos_list.add(sailor);
			sailor = new Sailor(4);
			this.pos_list.add(sailor);
			sailor = new Sailor(5);
			this.pos_list.add(sailor);
			sailor = new Sailor(5);
			this.pos_list.add(sailor);
			break;
		}
	}
	

	
	/**
	 * 使船在海中前进，更新船在海中的位置和在船在图形界面上的位置
	 * @param step 船在海中前进的步数
	 */
	public void move(int step){
		if(this.state == 1) {
			this.pos_in_the_sea += step;
		}	
		if(this.pos_in_the_sea >= 14 && this.state == 1) {
			this.pos_in_the_sea = 14;
			state = 2;
		}
		
		/**如果有窗口的话，加入下面这行，但是参数还没有调好*/
		//this.posY -= step * PlaygroundView.SEA_INTERVAL;
	}
	
	/**
	 * 这个函数也没有写好，里面是对船
	 * 当一个玩家分配海员登上该船时，调用该函数用以更新船上位置的信息
	 * @param pid 登船玩家的ID
	 *  * getSailarID是Position里面的一个方法，-1代表没有被占位置，这个位置是空的
	 */
	public boolean getOnboard(int pid){
		if(this.setPosPid(pid)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 获得该船当前空着的位置的编号（登船时自动从较低的编号开始）
	 * @return 当前编号最小的空位所对应的编号值
	
	 */
	public int getAvailPosIndex(){
		for(int i=0; i<this.pos_list.size(); i++){
			if(this.pos_list.get(i).getplayer_id() == -1) {
				return i;
			}
		}
		// no position left
		return -1;
	}
	
	/** 
	 * @return 当前可用位置的价格
	 */
	public int getPosPrice()
	{
		if(this.getAvailPosIndex() != -1) {
			return this.pos_list.get(this.getAvailPosIndex() - 1).getPrice();
		}
		return this.pos_list.get(this.pos_list.size() - 1).getPrice();
	}
	
	/**
	 * 船是否到达港口
	 */
	public boolean entered() {
		if(this.state == 2) {
			return true;
		}
		return false;
	}
	
	/**
	 * 船是否失事
	 */
	public boolean wrecked() {
		if(this.state == 0) {
			return true;
		}
		return false;
	}
	
	/**设置船上位置对应的玩家id
	 * @param ID 玩家ID
	 * 
	 * getAvailPosIndex()返回的是当前空着的位置号码
	 */
	
	public boolean setPosPid(int ID)
	{
		if(this.getAvailPosIndex() != -1) {
			this.pos_list.get(this.getAvailPosIndex()).setplayer_id(ID);
			return true;
		}
		return false;
	}

	public int getBoatID() {
		return boatID;
	}

	public void setBoatID(int boatID) {
		this.boatID = boatID;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPos_in_the_sea() {
		return pos_in_the_sea;
	}

	public void setPos_in_the_sea(int pos_in_the_sea) {
		this.pos_in_the_sea = pos_in_the_sea;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ArrayList<Sailor> getPos_list() {
		return pos_list;
	}

	public void setPos_list(ArrayList<Sailor> pos_list) {
		this.pos_list = pos_list;
	}

}
