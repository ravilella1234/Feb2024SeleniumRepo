package icici.loans.carloans;

public class B extends A
{
	public void m2()
	{
		System.out.println("iam m2 from B");
	}
	
	public void m1()
	{
		System.out.println("iam m1 from A");
	}

	public static void main(String[] args) 
	{
		B b = new B();
		b.m2();
		b.m1();
		
		A a = new A();
		a.m1();
	}

}
