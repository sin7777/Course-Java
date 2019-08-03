package TheActandClubs;
import java.util.ArrayList;

public class Club {
	private String name;
	public int order;
	public ArrayList<Activity> activity_list=new ArrayList<Activity>();
	private String introduction;
	private String founding_time;
	public ArrayList<Person> person_list=new ArrayList<Person>();
	public Contact contact=new Contact();
	public Leader leader=new Leader();
	public Club()
	{
		this.name="������";
		this.introduction="���ǻ�����";
		this.founding_time="2015.6.12";
	}
	public Club(String name,String time,String intro)
	{
		this.name=name;
		this.founding_time=time;
		this.setIntroduction(intro);
	}
	public void setActivityList(ArrayList<Activity> act1)
	{
		for(int i=0;i<act1.size();i++)
		{
			this.activity_list.add(act1.get(i));
		}
	}
	public void addActivity(Activity e)
	{
		this.activity_list.add(e);
	}
	public void setIntroduction(String intro)
	{
		this.introduction=intro;
	}
	public void setContact(Contact c)
	{
		this.contact=c;
	}
	public void setLeader(Leader lead)
	{
		this.leader=lead;
	}
	public String  getName() {
		return this.name;
	}
	public void setName(String string) {
		this.name=string;
	}
	public void setTime(String string) {
		this.founding_time=string;
	}
	public String getTime() {
		return this.founding_time;
	}
	public String getIntroduction() {
		return this.introduction;
	}
	public long getEstablishTime()
	{
		String[] time=this.founding_time.split(".");
		return Long.parseLong(time[0])*365*24*3600*1000+Long.parseLong(time[1])*30*24*3600*1000+Long.parseLong(time[2])*24*3600*1000;
	}
	public int getMemberNumber() {
		int num=this.person_list.size();
		return num;
	}
	public int getOrder() {
		// TODO Auto-generated method stub
		return this.order;
	}
	public void getInformation()
	{
		System.out.print(this.getName()+"  ");
		System.out.print(this.getTime()+"  ");
		System.out.print(this.leader.name+"  ");
		System.out.print(this.contact.getPhone()+"  ");
		System.out.print(this.contact.getMail()+"  ");
			for(int j=0;j<this.person_list.size();j++)
			{
				System.out.print(this.person_list.get(j).name+"  ");
			}
		System.out.println(this.getIntroduction()+"  ");
	}
	public boolean compareTime(String time)
	{
		String input_time[]=this.founding_time.split("[.]");
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
