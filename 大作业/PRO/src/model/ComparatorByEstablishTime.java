package model;

import java.util.Comparator;

public class ComparatorByEstablishTime implements Comparator{

	@Override
	public int compare(Object c1, Object c2) {
		// TODO Auto-generated method stub
		if(c1 instanceof Club)
		{
			if(((Club) c1).getEstablishTime()<((Club) c2).getEstablishTime())
				return -1;
			else if(((Club) c1).getEstablishTime()==((Club) c2).getEstablishTime())
				return 0;
			else
				return 1;
		}
		else if(c1 instanceof Activity)
		{
			if(((Activity) c1).getEstablishTime()<((Activity) c2).getEstablishTime())
				return -1;
			else if(((Activity) c1).getEstablishTime()==((Activity) c2).getEstablishTime())
				return 0;
			else
				return 1;
		}
		else
			throw new RuntimeException();
	}

}
