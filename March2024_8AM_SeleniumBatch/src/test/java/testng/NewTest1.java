package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest1 {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) 
  {
	  System.out.println("f test");
  }
  
  @Test(dataProvider = "dp1")
  public void g(Integer n, String s) 
  {
	  System.out.println("g test");
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("After Method");
  }


  @DataProvider
  public Object[][] dp() 
  {
	  System.out.println("dp");
    return new Object[][] {
      new Object[] { 1, "a" },
      
    };
  }
  
  @DataProvider
  public Object[][] dp1() 
  {
	  System.out.println("dp1");
    return new Object[][] {
    	new Object[] { 2, "b" },
    };
  }
}
