package assertionPack;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class OneTestValueToAnotherTest 
{
	
  @Test
  public void f1(ITestContext context) 
  {
	  String  bookingID = "abc134";
	  System.out.println("From f1 :" + bookingID);
	  context.setAttribute("BID", bookingID); 
  }
  
  @Test
  public void f2(ITestContext context) 
  {
	  //System.out.println("From f2 :" +bookingID);
	  String ID = (String)context.getAttribute("BID");
	  System.out.println("From f2 :" + ID);
  }
  
}
