package testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.project.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest
{
 
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  System.out.println("BeforeMethod");
	    init();
		test = report.createTest("TNG_002");
		test.log(Status.INFO, "Init the properties files...");	
		
		launch(btype);
		test.log(Status.PASS, "Opened the browser : " + btype);
		
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigated to application : " + childprop.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
  }
  
  
  @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	  	System.out.println("amazon test");
	    selectOption("amazonsearchdropbox_id","Books");
		test.log(Status.FAIL, "selected the option Books By using locator : " + orProp.getProperty("amazonsearchdropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered text Harry potter By ung the locator : " +  orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonserachbutton_xpath");
		test.log(Status.PASS, "Clicked the element By uing locator : " +  orProp.getProperty("amazonserachbutton_xpath"));
  }

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
  {
	  System.out.println("AfterMethod");
	  report.flush();
	  driver.quit();
  }

}
