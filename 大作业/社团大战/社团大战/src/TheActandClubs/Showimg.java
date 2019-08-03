package TheActandClubs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Showimg {
	public int selectImg() {
		Random random=new Random();
		int rand =random.nextInt(100);
		return rand+1;
	}
	public void showImg(int n,int m) throws IOException {
		Manage test=new Manage();
		test.setClubList();
		for(int i=1;i<11;i++) {
			System.out.println(test.club.get(i).getName()+":");			
			BufferedReader reader = new BufferedReader(new FileReader("src/TheActandClubs/img/"+i+"/testImg ("+((n+i)%10+1)+").txt"));
			String line = null; 												
			while((line=reader.readLine())!=null) {
				String imgpath=line;
				System.out.print(imgpath);
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader("src/TheActandClubs/img/"+i+"/testImg ("+((m+i)%10+1)+").txt"));
			line = null; 
			while((line=reader.readLine())!=null) {
				String imgpath=line;
				System.out.println(imgpath);
			}
			reader.close();			
		}
	}
}
