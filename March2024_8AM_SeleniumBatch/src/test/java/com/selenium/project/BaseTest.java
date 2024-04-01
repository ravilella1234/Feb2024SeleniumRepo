package com.selenium.project;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	
	public static WebDriver driver;
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orProp;
	public static String projectpath = System.getProperty("user.dir")+"\\src\\test\\resources";
	public static ExtentReports report;
	public static ExtentTest test;
	
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
		
		fis = new FileInputStream(projectpath+"\\log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
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
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for element presence
		if(!isElementPresence(locatorKey))
			//report as failure
			//System.out.println("Element is not present :" + locatorKey);
			test.log(Status.FAIL, "Element is not present :" + orProp.getProperty(locatorKey));
		
		element = driver.findElement(getLocator(locatorKey));
		
		/*if(locatorKey.endsWith("_id")) {
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
		}*/
		
		return element;
	}


	public static boolean isElementPresence(String locatorKey) 
	{
		System.out.println("Checking for element presence :" + locatorKey);
				
		
			try 
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
				return true;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
			
		/*if(locatorKey.endsWith("_id")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
	}else if(locatorKey.endsWith("_name")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
	}else if(locatorKey.endsWith("_classname")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
	}else if(locatorKey.endsWith("_xpath")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
	}else if(locatorKey.endsWith("_cssSelector")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));
	}else if(locatorKey.endsWith("_linktext")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));
	}else if(locatorKey.endsWith("_partiallinktext")) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));
	}*/
	}
	
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_cssselector")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		
		return by;
		
	}
	
	public static boolean isLinkEqual(String expectedLink) 
	{
		String actuallink = driver.findElement(By.linkText("Customer Service")).getText();
		if(!expectedLink.equals(actuallink))
			return false;
		else
			return true;
	}
	
	public static void reportPass(String passMessage) 
	{
		test.log(Status.PASS, passMessage);
	}

	public static void reportFailure(String failMessage) throws Exception 
	{
		test.log(Status.FAIL, failMessage);
		takesScreenshot();
	}
	
	public static void takesScreenshot() throws Exception
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
		
		test.log(Status.INFO,"Screenshot --->" +test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
	}

}
