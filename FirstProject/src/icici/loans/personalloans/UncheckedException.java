package icici.loans.personalloans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UncheckedException 
{

	public static void m1() throws Exception 
	{
		BufferedReader b = new BufferedReader(new FileReader("d://abc.txt"));
	}
	
	
	public static void main(String[] args) throws Exception
	{
		UncheckedException.m1();
	}

}
