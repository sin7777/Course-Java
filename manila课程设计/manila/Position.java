package manila;

public class Position {
	private int price;
	private int sailorID;
	
	public Position(int p){
		this.price = p;
		this.sailorID = -1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSailorID() {
		return sailorID;
	}

	public void setSailorID(int sailorID) {
		this.sailorID = sailorID;
	}
	
	
}
