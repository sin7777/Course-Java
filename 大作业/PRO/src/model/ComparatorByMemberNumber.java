package model;

import java.util.Comparator;

public class ComparatorByMemberNumber implements Comparator<Club>{

	@Override
	public int compare(Club c1, Club c2) {
		// TODO Auto-generated method stub
		if(((Club) c1).getMemberNumber()<((Club) c2).getMemberNumber())
			return -1;
		else if(((Club) c1).getMemberNumber()==((Club) c2).getMemberNumber())
			return 0;
		else
			return 1;
	}

}
