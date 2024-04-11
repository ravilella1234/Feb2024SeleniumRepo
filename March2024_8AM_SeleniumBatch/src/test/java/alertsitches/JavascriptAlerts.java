package alertsitches;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptAlerts 
{

	public static void main(String[] args) throws Exception 
	{
		
		/*
		 * 1) Java script Alerts
      			Prompt Alerts
      			Confirmation Dialog Alerts
      			Authentication Popup
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		
		//1.Java script Alert
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		
		//2.Confirmation Dialog Alerts
		
		/*driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		Alert a = driver.switchTo().alert();
		String txt = a.getText();
		System.out.println(txt);
		//a.accept();
		a.dismiss();*/
		
		//3.Prompt Alert
		/*driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert a = driver.switchTo().alert();
		a.sendKeys("Hello");
		Thread.sleep(3000);
		a.accept();
		
		driver.findElement(By.linkText("Elemental Selenium")).click();*/
		
		//4.Authentication Popup
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
