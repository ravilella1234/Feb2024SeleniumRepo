package assertionPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertion 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        
        String expectedLink = "Customer Serv";
        String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
        
        SoftAssert obj = new SoftAssert();
       // obj.assertEquals(actualLink, expectedLink);
        obj.assertTrue(actualLink.equals(expectedLink), "Both link are  not equal....");
        driver.findElement(By.linkText("Customer Service")).click();
        
        obj.assertTrue(false, "err1");
        
        obj.assertTrue(false, "err2");
        
        obj.assertTrue(true, "err3");
        
        obj.assertTrue(false, "err4");
        
        obj.assertAll();
        
	}

}
