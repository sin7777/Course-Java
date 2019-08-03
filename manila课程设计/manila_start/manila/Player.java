package manila;

public class Player {
	private String name;
	private int pid; // the ID of the player, start from 0
	private int account_balance;
	
	public Player(String name, int pid){
		this.name = name;
		this.pid = pid;
		this.account_balance = 30; // all the players start with 30$
	}

	public void receiveProfit(int profit){
		this.account_balance += profit;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public void payPos(int amount){
		this.account_balance -= amount;
	}

	public int getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	
}
