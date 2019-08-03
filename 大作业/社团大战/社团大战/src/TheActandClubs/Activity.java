package TheActandClubs;


import java.util.ArrayList;

public class Activity {
	/*public Leader leader;
	public Contact contact;
	public ArrayList<Person> person_list=new ArrayList<Person>();*/
	private  String name;
	private  String start_time;
	private  String destination;
	public  ArrayList<Club> club_list=new ArrayList<Club>();
	private  String introduction="ï¿½ï¿½ï¿½ï¿½Ò»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½";
	public String place;
	public int order;
	private String ps="ÔÝÊ±ÎÞ±¸×¢";
	public Activity()
	{
		Leader lead=new Leader();
		//this.leader=lead;
		Contact con=new Contact();
		//this.contact=con;
	}
	public Activity(String name,String time,String destination)
	{
		this.name=name;
		this.destination=destination;
		this.start_time=time;
	}
	public void setIntroduction(String intro)
	{
		this.introduction=intro;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setDestination(String destination)
	{
		this.destination=destination;
	}
	public void setStartTime(String time)
	{
		this.start_time=time;
	}
	public void setClubList(ArrayList<Club> array)
	{
		int i=0;
		for(Club e:array)
		{
			this.club_list.add(array.get(i));
			i++;
		}
	}
	public String getStartTime()
	{
		return this.start_time;
	}
	public String getIntroduction()
	{
		return this.introduction;
	}
	public String getDestination()
	{
		return this.destination;
	}
	public String getName()
	{
		return this.name;
	}
	public ArrayList<Club> getActList()
	{
		return this.club_list;
	}
	public long getEstablishTime()
	{
		String[] time=this.getStartTime().split(".");
		return Long.parseLong(time[0])*365*24*3600*1000+Long.parseLong(time[1])*30*24*3600*1000+Long.parseLong(time[2])*24*3600*1000;
	}
	public int getOrder() {
		
		return this.order;
	}
	public void getInformation() {
		System.out.print(this.getName()+" |");
		System.out.print(this.getStartTime()+" |");
		System.out.print(this.place+" |");
		for(int j=0;j<this.club_list.size();j++)
		{
			System.out.print(this.club_list.get(j).getName()+"  |");
		}
		System.out.println(this.getIntroduction());
	}
	public void setPs(String newContent) {
		this.ps=newContent;
		
	}
	public String getPs() {
		return ps;
	}
	public boolean compareTime(String time) {

		String input_time[]=this.start_time.split("[.]");
		String my_time[]=time.split("[.]");

		Integer[] mytime=new Integer[my_time.length];
		Integer[] inputtime=new Integer[my_time.length];
		for(int i=0;i<3;i++)
		{
			mytime[i]=Integer.parseInt(my_time[i]);
			inputtime[i]=Integer.parseInt(input_time[i]);

		}
		long time1=mytime[0]*365+mytime[1]*30+mytime[2];
		long time2=inputtime[0]*365+inputtime[1]*30+inputtime[2];
		return (time1>time2 ? false : true);
	}
}
