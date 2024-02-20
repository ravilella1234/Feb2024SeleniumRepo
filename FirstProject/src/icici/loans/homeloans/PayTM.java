package icici.loans.homeloans;

public class PayTM 
{

	public static void main(String[] args) 
	{
		Axis a = new Axis();
		System.out.println("Through PayTM : " + a.getMainBalance());
		
		a.setMainBalance(1500);
		System.out.println("Through PayTM Updated Balance : " +  a.getMainBalance());

	}

}
