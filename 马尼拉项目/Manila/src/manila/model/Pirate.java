package manila.model;

public class Pirate extends Position {

	public Pirate(int price) {
		super(price);
	}


	public boolean getOnBoard(Boat boat) {
		if(boat.getOnboard(this.player_id)) {
			this.player_id = -1;
			return true;
		}
		return false;
	}
	
	/**
	 * 海盗掠夺船只，清空船上已有玩家并登船，然后决定让船入港或是沉没
	 * @param boat 掠夺的船的id
	 * @param command 指令，true表示让船入港，false表示让船沉没
	 */
	public void rob(Boat boat, boolean command) {
		for(int i=0; i < boat.getPos_list().size(); i++){
			boat.getPos_list().get(i).setplayer_id(-1);
		}
		boat.getOnboard(this.player_id);
		this.player_id = -1;
		if(command) {
			boat.setState(2);
		}
		else {
			boat.setState(0);
		}
	}
}
