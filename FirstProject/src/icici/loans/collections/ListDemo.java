package icici.loans.collections;

import java.util.ArrayList;

public class ListDemo 
{

	public static void main(String[] args) 
	{
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(10);
		a.add("ravi");
		a.add(12.34f);
		a.add(20);
		a.add(10);
		a.add(30);
		
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.isEmpty());
		System.out.println(a.get(1));
		System.out.println(a.add(40));
		System.out.println(a);
		
		a.add(1, "sai");
		System.out.println(a);
		
		a.set(2, "ravikanth");
		System.out.println(a);
		
		System.out.println(a.indexOf(12.34f));
		
		System.out.println(a.contains("ravikanth"));
		
		System.out.println(a.subList(1, 5));
		
		a.remove(2);
		System.out.println(a);
		
		a.remove("sai");
		System.out.println(a);
		
		a.clear();
		System.out.println(a);
	}

}
