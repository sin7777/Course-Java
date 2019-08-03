package TheActandClubs;

import java.util.ArrayList;

public class Competition extends Activity {
	public ArrayList<Person> winner_list=new ArrayList<Person>();
	public Competition() {
		// Auto-generated constructor stub
		Person winner1=new Person();
		this.winner_list.add(winner1);
	}
	public Competition(ArrayList<Person> array)
	{
		for(int i=0;i<this.winner_list.size();i++)
		{
			this.winner_list.add(array.get(i));
		}
	}
}
