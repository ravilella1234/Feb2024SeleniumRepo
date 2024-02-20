package icici.loans.homeloans;

import icici.loans.carloans.A;
import icici.loans.carloans.B;

public class C extends A
{
	public void m3()
	{
		System.out.println("iam m3 from C");
	}

	
	public void m1()
	{
		System.out.println("iam m1 from A");
	}
	
	public static void main(String[] args) 
	{
		C c = new C();
		c.m3();
		c.m1();
		
		B b = new B();
		b.m2();
		b.m1();
		
		A a = new A();
		a.m1();
	}

}
