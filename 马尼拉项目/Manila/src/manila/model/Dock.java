package manila.model;

public class Dock extends Position {
	private int profit;
	
	
    public Dock(int price,int profit) {
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
