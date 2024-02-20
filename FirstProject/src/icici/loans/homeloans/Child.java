package icici.loans.homeloans;


class Parent
{
	public int workhard()
	{
		System.out.println("Parent : wakeup early, goto college...");
		return 0;
	}
	
	public void care()
	{
		System.out.println("Parent : Atmost care...");
	}
}


public class Child extends Parent
{
	
	public  int workhard()
	{
		System.out.println("Child : wakeup anytime, goto movies...");
		return 0;
	}
	
	public void love()
	{
		System.out.println("Child : iam in love....");
	}

	public static void main(String[] args) 
	{
		Child c = new Child();
		c.workhard();
		c.care();
		c.love();
	}

}
