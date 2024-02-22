package icici.loans.personalloans;

import java.util.Scanner;

public class ExceptionDemo 
{

	public static void main(String[] args) 
	{
		int nr, dr ,result;
		Scanner sc = new Scanner(System.in);
		
		//ArithmeticException e = new ArithmeticException();
		while(true) 
		{
			System.out.println("Enter the Nr vale : ");
			nr = sc.nextInt();
			System.out.println("Enter the Dr vale : ");
			dr = sc.nextInt();
			
			try 
			{
				result = nr / dr;
				System.out.println("Result is : " + result);
				break;
			} 
			catch (ArithmeticException e) 
			{
				e.printStackTrace();
			} 
		}
	}

}
