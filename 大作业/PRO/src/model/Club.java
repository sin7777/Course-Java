package model;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;

import com.csvreader.CsvReader;

public class Club {
	private int order;
	private String name;
	private String[] time;
	private String chiefName;
	private String chiefPhone;
	private String chiefEmail;
	private String[] members;
	private String activities; 
	private String clubInformation;
	
	public String getName()
	{
		return name;
	}
	
	public long getEstablishTime()
	{
		return Long.parseLong(time[0])*365*24*3600*1000+Long.parseLong(time[1])*30*24*3600*1000+Long.parseLong(time[2])*24*3600*1000;
	}
	
	public int getMemberNumber()
	{
		return members.length;
	}
	
	public String toString()
	{
		String times=time[0];
		times+=".";
		times+=time[1];
		times+=".";
		times+=time[2];
		String memberss="";
		for(String t : members)
		{
			memberss+=t;
			memberss+="、";
		}
		return ("<html>" + name + "<br>" + times + "<br>" + chiefName + "<br>" + chiefPhone + "<br>" + chiefEmail
				 + "<br>" + memberss + "<br>" + activities + "<br>" + clubInformation + "</html>");
	}
	
	public int getOrder()
	{
		return order;
	}
	
	public static ArrayList<Club> createClubs()
	{
		ArrayList<Club> clubs=null;
		 try {      
             
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据  
             String csvFilePath = "社团表.csv";  
             CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("gbk"));    //一般用这编码读就可以了      
                
             reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
                
             while(reader.readRecord()){ //逐行读入除表头的数据      
                 csvList.add(reader.getValues());  
             }              
             reader.close();  
             clubs=new ArrayList<Club>(csvList.size()-1);
                
              for(int row=1;row<csvList.size();row++){
            	  clubs.add(new Club());
            	  clubs.get(row-1).setOrder(row);
            	  clubs.get(row-1).name=csvList.get(row)[0];
            	  clubs.get(row-1).time=csvList.get(row)[1].split("[.]");
            	  clubs.get(row-1).chiefName=csvList.get(row)[2];
            	  clubs.get(row-1).chiefPhone=csvList.get(row)[3];
            	  clubs.get(row-1).chiefEmail=csvList.get(row)[4];
            	  clubs.get(row-1).members=csvList.get(row)[5].split("、");
            	  clubs.get(row-1).activities=csvList.get(row)[6];
            	  clubs.get(row-1).clubInformation=csvList.get(row)[7];
              }
                
         }catch(Exception ex){  
        	 ex.printStackTrace();
         }  
		 
		 return clubs;
	}

	private void setOrder(int row) {
		// TODO Auto-generated method stub
		order=row;
	}

	public static void main(String[] args)
	{
		for(Club club : createClubs())
		{
			System.out.println(club);
		}
		
	}
}
