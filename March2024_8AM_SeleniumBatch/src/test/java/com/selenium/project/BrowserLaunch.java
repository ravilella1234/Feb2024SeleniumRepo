package com.selenium.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/ravi/Downloads/chromedriver_win32/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/Users/ravi/Downloads/chromedriver_win32/chromedriver.exe");)
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		//webdriver.gecko.driver
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.bestbuy.com");
		
		//webdriver.edge.driver
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.redbus.in");
	}

}
