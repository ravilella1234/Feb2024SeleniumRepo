package testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.project.BaseTest;

public class LinksTesting1 extends BaseTest
{
	
	@BeforeMethod(groups = {"regression"})
	@Parameters("browser")
	public void setup(String btype) throws Exception
	{
		System.out.println("startProcess");
	    init();
		test = report.createTest("LinksTesting1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		launch(btype);
		test.log(Status.INFO, "Opened the Browser :- " + btype);
						
		navigateUrl("googleurl");
		test.log(Status.PASS, "Navigated to app :-" + childprop.getProperty("googleurl"));
	}
	
	
	@Test(groups = {"regression"})
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod(groups = {"regression"})
	public void tearDown()
	{
		 System.out.println("endProcess");
		 report.flush();
			driver.quit();
	}

}
