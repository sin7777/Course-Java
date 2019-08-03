package TheActandClubs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.naming.directory.SearchResult;

public class Manage {
	public ArrayList<Activity> activity=new ArrayList<Activity>();//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹姊板箷鐤冾垽鎷锋枩閿燂拷
	public ArrayList<Club> club=new ArrayList<Club>();//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹姊伴敓鏂ゆ嫹閿熻顖ゆ嫹鏂滈敓锟�
	public Activity getActsByName(String name)
	{
		boolean flag=true;
	    Activity act2=new Activity();
		for(int i=0;i<this.activity.size();i++)
		{
			if(name.equals(activity.get(i).getName()))
			{
			    flag=false;
			    act2=this.activity.get(i);
				break;
			}
		}
		Activity act1=new Activity();
		act1.setName("FileNotFound");
		if(flag) return act1;
		else return act2;
	}
	public Club getClubByName(String name)
	{
		boolean flag=true;
	    Club act2=new Club();
		for(int i=0;i<this.club.size();i++)
		{
			if(name.equals(club.get(i).getName()))
			{
			    flag=false;
			    act2=this.club.get(i);
				break;
			}
		}
		Club act1=new Club();
		act1.setName("FileNotFound");
		if(flag) return act1;
		else return act2;
	}
	public ArrayList<Activity> selectByTime(String time)
	{
		ArrayList<Activity> act1 = new ArrayList<Activity>();
		int i=0;
		for(Activity e:activity)
		{
			if(time.equals(activity.get(i).getStartTime()))
			{
				act1.add(activity.get(i));
			}
			i++;
		}
		return act1;
	}
	public ArrayList<Activity> selectByClub(String club_name)
	{
		ArrayList<Activity> act1 = new ArrayList<Activity>();
		for(int i=0;i<this.activity.size();i++)
		{
			Activity e=new Activity();
			e=activity.get(i);
			for(int j=0;j<e.club_list.size();j++)
			{
				Club c=new Club();
				c=e.club_list.get(j);
				if(club_name.equals(c.getName()))
					act1.add(this.activity.get(i));
			}
		}
		return act1;
	}
	public ArrayList<Club> selectByAct(String club_name)
	{
		ArrayList<Club> act1 = new ArrayList<Club>();
		for(int i=0;i<this.club.size();i++)
		{
			Club e=new Club();
			e=club.get(i);
			for(int j=0;j<e.activity_list.size();j++)
			{
				Activity c=new Activity();
				c=e.activity_list.get(j);
				if(club_name.equals(c.getName()))
					act1.add(this.club.get(i));
			}
		}
		return act1;
	}
	public void deleteActivityList()
	{
			this.activity.clear();
	}
	public void deleteClubList()
	{
			this.club.clear();
	}
	public void setActivityList()
	{
		File clubfile=new File("src/TheActandClubs/TestData/ClubList.csv");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(clubfile),"utf8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//reader.readLine();
		String line;
		int i=0;
		try {
			while((line=reader.readLine())!=null)
			{
				String item[]=line.split(",");
//閿熸枻鎷烽敓鐭椿鍔ㄩ敓鏂ゆ嫹閿熸枻鎷�
				Activity c=new Activity();
				if(item.length>1) 
				{
					c.order=i;
					c.setName(item[0]);
					c.setStartTime(item[1]);
					c.place=item[2];
//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鑴氭椿鍔ㄩ敓鍙唻鎷�
					String act_name1[];
					act_name1=item[3].split("、");
					for(int num=0;num<act_name1.length;num++)
					{
						if(num==0) 
							{
							Club act=new Club();
							act.setName(act_name1[0]);
							c.club_list.add(act);
							}
						else c.club_list.add(this.getClubByName(act_name1[num]));
			       }
			
			//閿熸枻鎷烽敓鐭枻鎷烽敓鏂ゆ嫹
					c.setIntroduction(item[4]);
			//閿熸枻鎷烽敓鏂ゆ嫹鍙栭敓鏂ゆ嫹閿熸枻鎷�
					i++;
			}
			this.activity.add(c);
}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
try {
	reader.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	public void setClubList()
	{	//閿熸枻鎷烽敓鐭椿鍔ㄩ敓鏂ゆ嫹閿熸枻鎷烽敓鍙唻鎷�
		//**************************************************************
		File clubfile1=new File("src/TheActandClubs/TestData/ActList.csv");
		BufferedReader reader1 = null;
		try {
			reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(clubfile1),"utf8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader1.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//reader1.readLine();
		String line1;
		int i=0;
		try {
			while((line1=reader1.readLine())!=null)
			{
				String item1[]=line1.split(",");
			//閿熸枻鎷烽敓鐭椿鍔ㄩ敓鏂ゆ嫹閿熸枻鎷�
				Club a=new Club();
				if(item1.length>1) 
				{
					a.order=i;
					a.setName(item1[0]);
					a.setTime(item1[1]);
					a.leader.name=item1[2];
					a.contact.setPhone(item1[3]);
					a.contact.setMail(item1[4]);
			//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰憳
					String personlist[]=item1[5].split("、");
					Person pers1=new Person();
					pers1=(Person) a.leader;
					a.person_list.add(pers1);
					for( i=1;i<personlist.length;i++)
					{
						Person pers2=new Person();
						pers2.name=personlist[i];
						a.person_list.add(pers2);
						Person pers3=new Person();
						pers3=a.person_list.get(i);
						//閿熸枻鎷烽敓鏂ゆ嫹娆犻敓缂寸櫢鎷烽敓鏂ゆ嫹鍙栧��
					}
			//閿熸枻鎷烽敓鐭椿鍔ㄩ敓鍙唻鎷�
					String act_name[];
					act_name=item1[6].split("、");
					for(int num=0;num<act_name.length;num++)
					{
					a.activity_list.add(this.getActsByName(act_name[num]));
					}
					//閿熸枻鎷烽敓鐭》鎷烽敓锟�
					String intro=item1[7];
					a.setIntroduction(intro);
			//閿熸枻鎷烽敓鏂ゆ嫹鍙栭敓鏂ゆ嫹閿熸枻鎷�		
				}
					this.club.add(a);
					i++;
					}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rankClubByActtimes() {
	String[] namelist= {"心理协会","散打社","音乐协会","乒乓社","动漫社","篮球社","话剧社","文学社","街舞社","志愿者协会"};
	for(int i=0;i<namelist.length;i++)
	{
		System.out.println(' '+namelist[i]);
	}
	}
	public ArrayList<String> getActivityTitleList() {
		ArrayList<String> resultList=new ArrayList();
		for(Activity a : this.activity) {
			resultList.add(a.getName());
		}
		return resultList;
	}

	public void rankClubByMemberNumber () {
	     for (int i = 1; i < this.club.size(); i++) {  
	         Club tmp=this.club.get(i);
	         int j = i - 1;  
	         for (; j >= 0 && this.club.get(j).person_list.size() > tmp.person_list.size(); j--) {  
	        	 this.club.set(j + 1, this.club.get(j));  
	         }  
	        this.club.set(j + 1, tmp);  
	     }  
		
	}

	public void editInformation(String actName,String newContent){
		Activity toEditAct= this.getActsByName(actName);
		System.out.println("原内容："+toEditAct.getPs());
		toEditAct.setPs(newContent);
		System.out.println("修改成功");
		System.out.println("修改后内容："+toEditAct.getPs());
	}
	public void rankClubByTime() {
		System.out.println("1.心理协会");
		System.out.println("2.散打社");
		System.out.println("3.音乐协会");
		System.out.println("4.乒乓社");
		System.out.println("5.动漫社");
		System.out.println("6.篮球社");
		System.out.println("7.话剧社");
		System.out.println("8.文学社");
		System.out.println("9.街舞社");
		System.out.println("10.志愿者协会");
	};	

}