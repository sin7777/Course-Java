package model;
import java.awt.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;

public class Activity {
	private int order;
	private String name;
	private String[] time;
	private String location;
	private String clubs;
	private String slogan;
	private String reference;
	
	public int getOrder()
	{
		return order;
	}
	
	private void setOrder(int row)
	{
		order=row;
	}
	
	public String getName()
	{
		return name;
	}
	
	public long getEstablishTime()
	{
		return Long.parseLong(time[0])*365*24*3600*1000+Long.parseLong(time[1])*30*24*3600*1000+Long.parseLong(time[2])*24*3600*1000;
	}
	
	public String toString()
	{
		String times=time[0];
		times+=".";
		times+=time[1];
		times+=".";
		times+=time[2];
		return "<html>" + name + "<br>" + times + "<br>" + location + "<br>" + clubs + "<br>" + slogan + "<br>" + reference + "</html>";
	}
	
	public static ArrayList<Activity> createActivities()
	{
		ArrayList<Activity> activities=null;
		try{
			ArrayList<String[]> csvList=new ArrayList<String[]>();
			CsvReader reader=new CsvReader("活动表.csv",',',Charset.forName("gbk"));
			reader.readHeaders();
			while(reader.readRecord())
			{
				csvList.add(reader.getValues());
			}
			reader.close();
			
			activities=new ArrayList<Activity>(csvList.size()-1);
			for(int row=1;row<csvList.size();row++)
			{
				activities.add(new Activity());
				activities.get(row-1).setOrder(row);
				activities.get(row-1).name=csvList.get(row)[0];
				activities.get(row-1).time=csvList.get(row)[1].split("[.]");
				activities.get(row-1).location=csvList.get(row)[2];
				activities.get(row-1).clubs=csvList.get(row)[3];
				activities.get(row-1).slogan=csvList.get(row)[4];
				activities.get(row-1).reference=csvList.get(row)[5];
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return activities;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Activity> list=createActivities();
		for(Activity a : list)
			System.out.println(a.getEstablishTime());
	}
}
