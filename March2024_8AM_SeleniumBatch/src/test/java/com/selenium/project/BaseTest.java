package com.selenium.project;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	
	public static WebDriver driver;
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orProp;
	public static String projectpath = System.getProperty("user.dir")+"\\src\\test\\resources";
	
	public static void init() throws Exception
	{
		
		File f = new File(projectpath+"\\data.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
		String val = p.getProperty("chromebrowser");
		//System.out.println(val);
		
		fis = new FileInputStream(projectpath+"\\environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"\\"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		String v = childprop.getProperty("amazonurl");
		System.out.println(v);
		
		fis = new FileInputStream(projectpath+"\\or.properties");
		orProp = new Properties();
		orProp.load(fis);
	}
	
	
	public static void launch(String browserType)
	{
		if(p.getProperty(browserType).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(p.getProperty(browserType).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(p.getProperty(browserType).equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(url);
		driver.navigate().to(childprop.getProperty(url));
	}
	
	public static void clickElement(String locatorKey) 
	{
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
		getLocator(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
		getLocator(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		getLocator(locatorKey).sendKeys(option);
	}
	
	public static WebElement getLocator(String locatorKey) 
	{
		WebElement element = null;
		
		if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_cssSelector")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linkText")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partialLinkText")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}
		return element;
	}

}
