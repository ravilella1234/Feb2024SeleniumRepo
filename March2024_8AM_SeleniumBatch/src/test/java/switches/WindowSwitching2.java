package switches;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitching2 
{
	public static WebDriver driver;

	public static Boolean switchToRightWindow(String windowTitle, List<String> hList)
	{
		for(String e : hList)
		{
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("Found the right window...");
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		System.out.println(driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
				
		driver.findElement(By.xpath("//img[@alt='redbus_facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='redbus_linkedin']")).click();
		driver.findElement(By.xpath("//img[@alt='redbus_twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='redbus_instagram']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(handles);
		
		//How to switch To Right Window
		if(switchToRightWindow("redBus | LinkedIn", hList))
		{
			System.out.println(driver.getCurrentUrl() + ":" + driver.getTitle());
		}
		
		//How to close all child Windows and switch back to parent Windows
	}
}
