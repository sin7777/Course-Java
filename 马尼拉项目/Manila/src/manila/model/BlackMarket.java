package manila.model;

/**
 * 
 * 股票对应ID：
 * nutmeg-1;
 * silk-2;
 * ginseng-3;
 * jade-4;
 * @author Phagesama
 * 
 */

public class BlackMarket {
	int nutmeg_value;
	int silk_value;
	int ginseng_value;
	int jade_value;
	int avail_nutmeg;
	int avail_silk;
	int avail_ginseng;
	int avail_jade;
	
	static final int[] price = {0, 5, 10, 20, 30};
	
	public BlackMarket()
	{
		nutmeg_value = 0;
		silk_value = 0;
		ginseng_value = 0;
		jade_value = 0;
		avail_nutmeg = 5;
		avail_silk = 5;
		avail_ginseng = 5;
		avail_jade = 5;
	}
	
	/**
	 * 判断是否有货物对应股票涨到30元
	 * @return
	 */
	
	public boolean reachThirty()
	{
		if ((nutmeg_value == 2)||(silk_value == 2)||(ginseng_value == 2)||(jade_value == 2))
			return true;
		else return false;
	}
	
	/**
	 * 某一货物对应股票涨价，若已达到最高价格返回false
	 * @param id
	 * @return
	 */
	
	public boolean riseInPrice(int id)
	{
		if ((id == 1) && (nutmeg_value < 4)) 
		{
			nutmeg_value++;
			return true;
		}
		if ((id == 2) && (silk_value < 4)) 
		{
			silk_value++;
			return true;
		}
		if ((id == 3) && (ginseng_value < 4)) 
		{
			ginseng_value++;
			return true;
		}
		if ((id == 4) && (jade_value < 4)) 
		{
			jade_value++;
			return true;
		}
		return false;
	}
	
	/**
	 * 卖出一份相应ID的股票,
	 * 若这份股票售空则返回false
	 * @param stocksID
	 */
	public boolean sailstocks(int stocksID)
	{
		if (stocksID == 1) 
		{
			if (avail_nutmeg>0)
			{
				avail_nutmeg--;
				return true;
			}
			else return false;
		}
		if (stocksID == 2) 
		{
			if (avail_silk>0)
			{
				avail_silk--;
				return true;
			}
			else return false;
		}
		if (stocksID == 3)
		{
			if (avail_ginseng>0)
			{
				avail_ginseng--;
				return true;
			}
			else return false;
		}
		if (stocksID == 4) avail_jade--;
		{
			if (avail_jade>0)
			{
				avail_jade--;
				return true;
			}
			else return false;
		}
	}
	
	/**
	 * 获取一种股票的价值
	 * @param stocksID
	 * @return
	 */
	
	public int getnutmeg()
	{
		return nutmeg_value;
	}
	
	public int getsilk()
	{
		return silk_value;
	}
	
	public int getginseng()
	{
		return ginseng_value;
	}
	
	public int getjade()
	{
		return jade_value;
	}
	
	public int getValueBystocksID(int stocksID)
	{
		if (stocksID == 1) return price[nutmeg_value];
		if (stocksID == 2) return price[silk_value];
		if (stocksID == 3) return price[ginseng_value];
		if (stocksID == 4) return price[jade_value];
		return 0;
	}
	
	public int getNutmeg_value() {
		return price[nutmeg_value];
	}
	public void setNutmeg_value(int nutmeg_value) {
		this.nutmeg_value = nutmeg_value;
	}
	public int getSilk_value() {
		return price[silk_value];
	}
	public void setSilk_value(int silk_value) {
		this.silk_value = silk_value;
	}
	public int getGinseng_value() {
		return price[ginseng_value];
	}
	public void setGinseng_value(int ginseng_value) {
		this.ginseng_value = ginseng_value;
	}
	public int getJade_value() {
		return price[jade_value];
	}
	public void setJade_value(int jade_value) {
		this.jade_value = jade_value;
	}
	public int getAvail_nutmeg() {
		return avail_nutmeg;
	}
	public void setAvail_nutmeg(int avail_nutmeg) {
		this.avail_nutmeg = avail_nutmeg;
	}
	public int getAvail_silk() {
		return avail_silk;
	}
	public void setAvail_silk(int avail_silk) {
		this.avail_silk = avail_silk;
	}
	public int getAvail_ginseng() {
		return avail_ginseng;
	}
	public void setAvail_ginseng(int avail_ginseng) {
		this.avail_ginseng = avail_ginseng;
	}
	public int getAvail_jade() {
		return avail_jade;
	}
	public void setAvail_jade(int avail_jade) {
		this.avail_jade = avail_jade;
	}

}
