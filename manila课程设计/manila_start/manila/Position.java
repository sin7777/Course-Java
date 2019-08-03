package manila;

public class Position {
	private int price; // the price that the player needs to pay for this position
	private int sailorID; // the ID of the player who chooses this position
	
	public Position(int p){
		this.price = p;
		this.sailorID = -1; // -1 means no player is at this position
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
