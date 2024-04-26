package testng;

import org.testng.annotations.Test;

import testngdataprovider.TestDataProvider;

public class TestUser 
{
	  @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
	  public void createUser(String browser,String usertype,Integer password, String email) 
	  {
		  System.out.println(browser +"----"+usertype +"----"+password+"----"+email);
	  }
	  
	  @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
	  public void deleteUser(String browser,String usertype,Integer password, String email) 
	  {
		  System.out.println(browser +"----"+usertype +"----"+password+"----"+email);
	  }
	  
	  @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
	  public void updateUser(String browser,String usertype,Integer password, String email) 
	  {
		  System.out.println(browser +"----"+usertype +"----"+password+"----"+email);
	  }
  
}
