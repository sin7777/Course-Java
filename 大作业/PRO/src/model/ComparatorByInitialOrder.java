package model;

import java.util.Comparator;

public class ComparatorByInitialOrder implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof Club)
		{
			if(((Club) o1).getOrder()<((Club) o2).getOrder())
				return -1;
			else if(((Club) o1).getOrder()==((Club) o2).getOrder())
				return 0;
			else
				return 1;
		}
		else if(o1 instanceof Activity)
		{
			if(((Activity) o1).getOrder()<((Activity) o2).getOrder())
				return -1;
			else if(((Activity) o1).getOrder()==((Activity) o2).getOrder())
				return 0;
			else
				return 1;
		}
		throw new RuntimeException();
	}
	
}
