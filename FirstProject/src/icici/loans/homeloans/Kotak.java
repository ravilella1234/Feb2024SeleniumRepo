package icici.loans.homeloans;

public class Kotak 
{
	private int mainbalance = 1000;
	
	public int getMainbalance()
	{
		System.out.println(mainbalance);
		return mainbalance;
	}
	
	public void setMainbalance(int bal)
	{
		mainbalance = bal;
	}
	
	public static void main(String[] args) 
	{
		Kotak k = new Kotak();
//		System.out.println(k.mainbalance);
		k.getMainbalance();
	}

}
