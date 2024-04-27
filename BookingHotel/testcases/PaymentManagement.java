package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManagement 
{
	
  @Test
  public void applyDiscount() 
  {
	  System.out.println("-------- applyDiscount ----------");
  }
  
  @Test
  @Parameters("action")
  public void makePayment(String parameterType,ITestContext context) 
  {
	  if(parameterType.equals("pay@hotel"))
		  System.out.println("-----  makePayment offline -----");
	  else 
		  System.out.println("------ makePayment online ------");
	  
	  //Booking ID
	  String bookingID = "RRR134";
	  System.out.println("BID : " + bookingID);
	  context.setAttribute("Bid", bookingID);
  }
  
}
