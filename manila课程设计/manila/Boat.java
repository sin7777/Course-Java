package manila;

public class Boat {
	private String cargo_name;
	private int cargo_value;
	private Position[] pos_list;
	private int pos_in_the_sea;
	
	public Boat(String n, int v, Position[] pl){
		this.cargo_name = n;
		this.cargo_value = v;
		this.pos_list = pl;
		this.pos_in_the_sea = 0;
	}
	
	public void getOnboard(int pid){
		this.pos_list[getAvailPosIndex()].setSailorID(pid);
	}
	
	public void move(int step){
		//TODO move the boat forward
	}
	
	public int getAvailPosIndex(){
		for(int i=0; i<this.pos_list.length; i++){
			//TODO get the first empty position
		}
		// no position left
		return -1;
	}
	
	// Get how many positions have been filled with sailors
	public int getFilledPosNum(){
		int pos_ind = getAvailPosIndex();
		if(pos_ind == -1)
			return this.pos_list.length;
		else
			return pos_ind;
	}
	
	// return the price to get onboard the boat
	public int getAvailPosPrice(){
		for(int i=0; i<this.pos_list.length; i++){
			//TODO
		}
		return -1;
	}

	public String getCargo_name() {
		return cargo_name;
	}

	public void setCargo_name(String cargo_name) {
		this.cargo_name = cargo_name;
	}

	public int getCargo_value() {
		return cargo_value;
	}

	public void setCargo_value(int cargo_value) {
		this.cargo_value = cargo_value;
	}

	public int getPos_in_the_sea() {
		return pos_in_the_sea;
	}

	public void setPos_in_the_sea(int pos_in_the_sea) {
		this.pos_in_the_sea = pos_in_the_sea;
	}

	public Position[] getPos_list() {
		return pos_list;
	}

	public void setPos_list(Position[] pos_list) {
		this.pos_list = pos_list;
	}
	
	
}
