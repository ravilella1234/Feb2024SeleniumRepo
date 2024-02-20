package icici.loans.carloans;

import java.io.FileInputStream;

public class FirstClass 
{
	
	// Data - Data Properties
	int a=10,b=20,c;
	
	// Operations - Behaviours
	
	public void add()
	{
		c = a+b;
		System.out.println("Add of A & B is : " +  c);
	}
	
	public void sub()
	{
		c = a - b;
		System.out.println("Sub of A & B is : " +  c);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Hello");
		FileInputStream fis;
		//ctrl+shift+O -  to add wanting imports & to remove un-wantings imports
		
		int x = 100;
		String str = "ravi";
		
		FirstClass obj = new FirstClass();
		obj.add();
		obj.sub();
		
		FirstClass obj1 = new FirstClass();
		obj1.add();
		obj1.sub();
	}
}
