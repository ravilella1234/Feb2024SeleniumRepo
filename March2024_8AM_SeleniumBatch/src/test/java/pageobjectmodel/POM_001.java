package pageobjectmodel;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.project.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class POM_001 extends BaseTest
{
	
  @Test
  public void f() 
  {
	  RegistrationPage obj = new RegistrationPage(driver);
	  obj.customerRegistration();
  }
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String btype) throws Exception 
  {
	    init();
		test = report.createTest("POM_001");
		test.log(Status.INFO, "Init the properties files...");	
		
		launch(btype);
		test.log(Status.PASS, "Opened the browser : " + btype);
		
		navigateUrl("registrationurl");
		test.log(Status.PASS, "Navigated to application : " + childprop.getProperty("registrationurl"));
		
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
