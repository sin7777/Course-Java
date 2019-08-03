package TheActandClubs;

public class Person {
	protected String name="³Â¸Õ";
	public int act_times=9;
	public Person()
	{
		this.name="AAA";
		this.act_times=9;
	}
	public Person(String n,int i)
	{
		this.name=n;
		this.act_times=i;
	}
	public String getPersonName()
	{
		return this.name;
	}
}
	