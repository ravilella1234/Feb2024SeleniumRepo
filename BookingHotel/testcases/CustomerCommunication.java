package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunication 
{
	
  @Test
  public void checkEmailVerification(ITestContext context) 
  {
	  String bookingID = (String)context.getAttribute("Bid");
	  System.out.println("---- checkEmailVerification ----- : " + bookingID);
  }
  
  @Test
  public void checkMobileVerification(ITestContext context) 
  {
	  String bookingID = (String)context.getAttribute("Bid");
	  System.out.println("------ checkMobileVerification  ------- : " +  bookingID);
  }
  
}
