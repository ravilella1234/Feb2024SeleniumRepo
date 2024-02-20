package icici.loans.homeloans;

public class PhonePe 
{
	
	public static void main(String[] args) 
	{
		Kotak k = new Kotak();
		//System.out.println(k.name);
		int n = k.getMainbalance();
		System.out.println(n);
		
		k.setMainbalance(900);
		int n1 = k.getMainbalance();
		System.out.println(n1);
	}

}
