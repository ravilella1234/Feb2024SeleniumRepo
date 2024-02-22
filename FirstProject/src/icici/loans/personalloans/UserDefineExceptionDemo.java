package icici.loans.personalloans;

import java.util.Scanner;

public class UserDefineExceptionDemo extends Exception
{

	public UserDefineExceptionDemo(String string) 
	{
		super(string);
	}

	public static void main(String[] args) 
	{
		String str;
		Scanner sc = new Scanner(System.in);
	
		while(true) 
		{
			System.out.println("Enter the 10 character String : ");
			str = sc.nextLine();
			
			try 
			{
				if (str.length() != 10) 
				{
					throw new UserDefineExceptionDemo("It  should be 10 character String");
				}
				else
				{
					System.out.println(str);
					break;
				}
			} 
			catch (UserDefineExceptionDemo e) 
			{
				e.printStackTrace();
			} 
		}
	}

}
