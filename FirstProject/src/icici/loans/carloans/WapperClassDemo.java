package icici.loans.carloans;

import java.util.ArrayList;

public class WapperClassDemo 
{

	public static void main(String[] args) 
	{
		//Where int is the primitive Type 
		int x = 10;
		System.out.println(x);
		
		//Integer x1 = new Integer(x);  //Boxing
		Integer x1 = Integer.valueOf(x);
		System.out.println(x1);
		int  i1 = x1;  // Auto -Unboxing
		System.out.println(i1);
		
		
		Integer x2 = x; // AutoBoxing
		System.out.println(x2); 
		
		ArrayList<Float> a = new ArrayList<Float>();
		a.add(12.34f);
	}

}
