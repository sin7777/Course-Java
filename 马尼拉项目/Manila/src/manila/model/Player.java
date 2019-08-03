package manila.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Phagesama
 *
 */

public class Player {
	private int ID;
	private int balance;
	private int avail_employee;
	private String name;
	private Color color;
	private ArrayList<Integer> stocks;
	private ArrayList<Integer> pledgestocks;
	
	/**
	 * 预装载的玩家名称
	 */
	
	private static String[] foreloadingname = {"Dovah", "Sagen", "Phage", "Hanck", "Jasmine"};
	
	/**
	 * 预装载的玩家颜色
	 */
	
	private static Color[] foreLoadingcolor = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK};
	
	public Player(int IDs, int gameScale)
	{
		ID = IDs;
		balance = 30;
		if (gameScale == 3) avail_employee = 3;
		else if (gameScale > 3) avail_employee = 3;
		name = foreloadingname[ID];
		color = foreLoadingcolor[ID];
		stocks = new ArrayList<Integer>();
		pledgestocks = new ArrayList<Integer>();
	}
	
	/**
	 * 预先发放两份随机股票
	 * @param bm
	 */
	
	public void foreLoadingStocks(BlackMarket bm)
	{
		Random r = new Random();
		int stocks1 = r.nextInt(3) + 1;
		int stocks2 = r.nextInt(3) + 1;
		stocks.add(stocks1);
		bm.sailstocks(stocks1);
		stocks.add(stocks2);
		bm.sailstocks(stocks2);
	}
	
	/**
	 * 购买一种股票，成功则返回true，失败返回false
	 * @param stocksID
	 * @param bm
	 * @return
	 */
	
	public boolean buyStock(int stocksID, BlackMarket bm)
	{
		if (bm.sailstocks(stocksID))
		{
			stocks.add(stocksID);
			return true;
		}
		else return false;
	}
	
	/**
	 * 向银行抵押一股股票，获得12元，成功返回true，失败返回false
	 * @param ba
	 * @return
	 */
	
	public boolean loan(Bank ba)
	{
		if (stocks.size() > 0)
		{
			pledgestocks.add(stocks.get(stocks.size()-1));
			stocks.remove(stocks.size()-1);
			this.gainMoney(12);
			return true;
		}
		return false;
	}
	
	/**
	 * 赎回一张股票，支出15元，成功返回true，失败返回false
	 * @param ba
	 * @return
	 */
	
	public boolean repayment(Bank ba)
	{
		if ((balance > 15) && (pledgestocks.size() > 0))
		{
			stocks.add(pledgestocks.get(pledgestocks.size()-1));
			pledgestocks.remove(pledgestocks.size()-1);
			this.pay(15);
			return true;
		}
		return false;
	}
	
	/**
	 * 获取玩家资产总和
	 * @param bm
	 * @return
	 */
	
	public int getProperty(BlackMarket bm)
	{
		int stocksvalue = 0;
		for (int i = 0; i < stocks.size(); i++) 
		{
			stocksvalue += bm.getValueBystocksID(stocks.get(i));
		}
		return balance + stocksvalue;
	}
	
	public boolean payForPosition(int price)
	{
		if ((balance > price) && (avail_employee > 0))
		{
			this.pay(price);
			avail_employee--;
			return true;
		}
		return false;
	}
	
	public void gainMoney(int money)
	{
		balance += money;
	}
	
	public void pay(int money)
	{
		balance -= money;
	}
	
	public void addStocks(int stocksID)
	{
		stocks.add(stocksID);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAvail_employee() {
		return avail_employee;
	}
	public void setAvail_employee(int avail_employee) {
		this.avail_employee = avail_employee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public ArrayList<Integer> getStocks() {
		return stocks;
	}
	public void setStocks(ArrayList<Integer> stocks) {
		this.stocks = stocks;
	}

	public ArrayList<Integer> getPledgestocks() {
		return pledgestocks;
	}

	public void setPledgestocks(ArrayList<Integer> pledgestocks) {
		this.pledgestocks = pledgestocks;
	}
	
}
