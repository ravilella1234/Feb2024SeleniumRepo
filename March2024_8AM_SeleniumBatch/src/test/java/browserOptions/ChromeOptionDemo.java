package browserOptions;



import java.util.Collections;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionDemo 
{

	public static void main(String[] args)
	{		
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		//option.addArguments("--headless");
		//option.addArguments("--incognito");
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//option.addArguments("--ignore-certificate-errors");
		//option.addArguments("--proxy-server=https://192.168.10.1:1744");
		option.addArguments("--user-data-dir=C:\\Users\\ravi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3");
		
		//Webnotification handling
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
	}

}
