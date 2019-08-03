package manila.model;

/**
 * NEW
 */
public class Position {
	/** 登上该位置所要支付的费用 */
    protected int price;
	/** 登上该位置的水手所对应的玩家ID，为空时值为-1 */
	protected int player_id;
	
	
	
	/**
	 * 位置构造函数
	 * @param p 坐该位置要支付的费用
	 */
	public Position(int p){
		this.price = p;
		this.player_id = -1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getplayer_id() {
		return player_id;
	}

	public void setplayer_id(int player_id) {
		this.player_id = player_id;
	}
	
	
}
