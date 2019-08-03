package manila.model;

public class Shipyard extends Position{

	private int profit;
	
	public Shipyard(int price,int profit) {
    	super(price);
    	setprofit(profit);
    }
	
	public int getprofit() {
		return profit;
	}
	public void setprofit(int profit) {
		this.profit = profit;
	}


}
