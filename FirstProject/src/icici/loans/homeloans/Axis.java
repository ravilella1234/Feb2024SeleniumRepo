package icici.loans.homeloans;

public class Axis 
{
	private int mainBalance = 2000;

	public int getMainBalance() 
	{
		System.out.println("Through Axis Bank : " + mainBalance);
		return mainBalance;
	}

	public void setMainBalance(int mainBalance) 
	{
		this.mainBalance = mainBalance;
	}
	
	public static void main(String[] args) 
	{
		Axis a = new Axis();
		System.out.println("Through Axis Bank : " + a.getMainBalance());
	}
	

}
