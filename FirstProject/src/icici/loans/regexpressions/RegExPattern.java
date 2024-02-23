package icici.loans.regexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPattern 
{

	public static void main(String[] args) 
	{
		//approach 1
		Pattern p = Pattern.compile("[679][0-9]{9}");
		Matcher m = p.matcher("7687676523");
		boolean b = m.matches();
		System.out.println(b);
		
		//approach 2
		boolean b1 = Pattern.matches("[679][0-9]{9}", "7687676523");
		System.out.println(b1);
		
		boolean b2 = Pattern.matches("[A-Z][a-z]*[0-9][a-z]*", "Ravi1kanth");
		System.out.println(b2);
		
		boolean b3 = Pattern.matches("[A-Z][a-z \\. 0-9]+[@][a-z]+[\\.][a-z]{2,3}", "Ravilella.1981@gmail.in");
		System.out.println(b3);
		
	}

}
