package manila.model;

public class Bank {

	private int balance;
	
	
	int gainMoney(int money){
		
		balance = balance + money;
		return money;	
	}
	
	int pay(int money){
		
		balance = balance - money;
		return money;
		
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
