package assertionPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertion 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        
        String expectedLink = "Customer Serv";
        String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
       
        //Assert.assertEquals(actualLink, expectedLink);
        Assert.assertTrue(actualLink.equals(expectedLink), "Both link are  not equal....");
        driver.findElement(By.linkText("Customer Service")).click();
	}

}
