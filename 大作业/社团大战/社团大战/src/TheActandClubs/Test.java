package TheActandClubs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

		public static void main(String[] args) throws FileNotFoundException, Exception {
		// TODO Auto-generated method stub
		Manage test1=new Manage();
		test1.setActivityList();
		test1.setClubList();
		test1.deleteActivityList();
		test1.setActivityList();
		test1.activity.remove(test1.activity.size()-1);
		System.out.println("Do you want to see the photos?(yes or no)");
		Scanner input=new Scanner(System.in);
		 if(input.nextLine().equals("yes"))
		{Showimg img=new Showimg();
		img.showImg(img.selectImg(),img.selectImg());}
		else if(input.nextLine().equals("no")) {}
		
		System.out.println("Please enter ‘Student’ or ‘Manager’ to enter（Student和manage均有社团信息，但查看详细信息功能均在student界面中，Manage中只有排序功能）");
		input=new Scanner(System.in);
		String choice;
		choice=input.nextLine();
		while(!(choice.equals("Student"))&&!(choice.equals("Manager")))
		{
			System.out.println("Please enter ‘Student’ or ‘Manager’ to enter");
			input=new Scanner(System.in);
			choice=input.nextLine();
		}
		if(choice.equals("Student"))
		{
			
			System.out.println("以下为社团信息");
			int i=0;
			for(i=0;i<test1.club.size();i++)
			{
				System.out.print(test1.club.get(i).getName()+"  ");
				System.out.print(test1.club.get(i).getTime()+"  ");
				System.out.print(test1.club.get(i).leader.name+"  ");
				System.out.print(test1.club.get(i).contact.getPhone()+"  ");
				System.out.print(test1.club.get(i).contact.getMail()+"  ");
				if(i==0) System.out.print("成员列表"+"  ");
				else
					{for(int j=0;j<test1.club.get(i).person_list.size();j++)
					{
						System.out.print(test1.club.get(i).person_list.get(j).name+"  ");
					}}
				System.out.println(test1.club.get(i).getIntroduction()+"  ");
			}
			System.out.println("以下为活动信息");
			i=0;
			for(i=0;i<test1.activity.size();i++)
			{	
				test1.activity.get(i).getInformation();
			}
			System.out.println("Please enter the Club name to select");
			Club test_c=new Club();
			Scanner club_name=new Scanner(System.in);
			test_c=test1.getClubByName(club_name.next());
			int club_num=test1.club.indexOf(test1.getClubByName(club_name.nextLine()));
			if(test_c.getName().equals("FileNotFound")) 
			{
				System.out.println("Sorry, not found");
			}
			else{
			test_c.getInformation();
			}
			System.out.println("Please enter the Activity name to select");
			Activity test_a=new Activity();
			club_name=new Scanner(System.in);
			test_a=test1.getActsByName(club_name.next());
			club_num=test1.activity.indexOf(test1.getClubByName(club_name.nextLine()));
			if(test_a.getName().equals("FileNotFound")) 
			{
				System.out.println("Sorry, not found");
			}
			else{
			test_a.getInformation();
			}
			System.out.println("Please enter the Club name to see the members");
			club_name=new Scanner(System.in);
			test_c=test1.getClubByName(club_name.next());
			if(test_c.getName().equals("FileNotFound")) 
			{
				System.out.println("Sorry, not found that Club");
			}
			else{
				for(i=0;i<test_c.person_list.size();i++)
				{
					System.out.print(test_c.person_list.get(i).name+' ');
				}
				System.out.println("");
			}

	}
		else if(choice.equals("Manager"))
		{
			System.out.println("此界面可进行排序");

			
			System.out.println("以下为社团信息");
			int i=0;
			for(i=0;i<test1.club.size();i++)
			{
				System.out.print(test1.club.get(i).getName()+"  ");
				System.out.print(test1.club.get(i).getTime()+"  ");
				System.out.print(test1.club.get(i).leader.name+"  ");
				System.out.print(test1.club.get(i).contact.getPhone()+"  ");
				System.out.print(test1.club.get(i).contact.getMail()+"  ");
				if(i==0) System.out.print("成员列表"+"  ");
				else
					{for(int j=0;j<test1.club.get(i).person_list.size();j++)
					{
						System.out.print(test1.club.get(i).person_list.get(j).name+"  ");
					}}
				System.out.println(test1.club.get(i).getIntroduction()+"  ");
			}
			System.out.println("以下为活动信息");
			i=0;
			for(i=0;i<test1.activity.size();i++)
			{
				test1.activity.get(i).getInformation();
			}
			System.out.println("按照成员数量拍序社团");
			test1.rankClubByMemberNumber();
			System.out.println("以下为排序后活动信息");
			for(i=0;i<test1.club.size();i++)
			{	
				test1.club.get(i).getInformation();
			}
			System.out.println("按照活动次数排序社团");
			test1.rankClubByActtimes();
			System.out.println("请按照年.月.日方式输入时间，显示该时间后的活动");
			input=new Scanner(System.in);
			String time=input.nextLine();
			for(i=1;i<test1.activity.size();i++)
			{
				boolean flag=test1.activity.get(i).compareTime(time);
				if(flag==true)
						test1.activity.get(i).getInformation();
			}
			System.out.println("请输入需要修改的社团名称及信息");
			input=new Scanner(System.in);
			Scanner name=new Scanner(System.in);
			test1.editInformation(input.nextLine(), name.nextLine());
		}
	}
}
