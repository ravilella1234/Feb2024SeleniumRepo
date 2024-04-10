package actionsprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDemo 
{
	public static WebDriver driver ;
	public static Actions a;
	
	public static void moueOverElement(String locator)
	{
		driver.get("https://www.amazon.in");
		a = new Actions(driver);
		WebElement e = driver.findElement(By.id(locator));
		a.moveToElement(e).perform();
		driver.findElement(By.xpath("//span[text()='Your Orders']")).click();
	}
	
	public static void dragAndDropElement(String sourceLocator, String targetLocator)
	{
		driver.get("https://jqueryui.com/droppable/");
		a = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id(sourceLocator));
		WebElement drop = driver.findElement(By.id(targetLocator));
		
		//a.dragAndDrop(drag, drop).perform();
		a.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	}
	
	public static void slidebarElement(String locator,String frameLocator )
	{
		driver.get("https://jqueryui.com/slider/");
		a = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.className(frameLocator)));
		WebElement e = driver.findElement(By.id(locator));
		
		//a.dragAndDropBy(e, 200, 0).perform();
		a.clickAndHold(e).moveByOffset(100, 0).release(e).build().perform();
	}
	
	public static void rightClick(String locator)
	{
		driver.get("https://jqueryui.com/slider/");
		a = new Actions(driver);
		WebElement e = driver.findElement(By.linkText(locator));
		a.contextClick(e).perform();
	}
	
	public static void doubleClick(String locator)
	{
		driver.get("https://www.amazon.in/");
		a = new Actions(driver);
		WebElement e = driver.findElement(By.id(locator));
		e.sendKeys("Harrypotter");
		a.doubleClick(e).perform();
	}
	
	public static void keyEnter(String locator)
	{
		driver.get("https://www.amazon.in/");
		a = new Actions(driver);
		WebElement e = driver.findElement(By.id(locator));
		e.sendKeys("HarryPotter");
		a.sendKeys(e, Keys.ENTER).perform();
	}
	
	public static void keyTab(String locator)
	{
		driver.get("https://www.facebook.com/");
		a = new Actions(driver);
		WebElement e = driver.findElement(By.id(locator));
		e.sendKeys("ravilella");
		a.sendKeys(Keys.TAB).perform();
	}
	
	public static void selectAll(String locator1,String locator2) throws Exception
	{
		driver.get("https://www.facebook.com/");
		a = new Actions(driver);
		WebElement loc1 = driver.findElement(By.id(locator1));
		WebElement loc2 = driver.findElement(By.id(locator2));
		
		loc1.sendKeys("ravi");
		Thread.sleep(4000);
		loc1.sendKeys(Keys.CONTROL + "a");
		loc1.sendKeys(Keys.CONTROL + "c");
		loc2.sendKeys(Keys.CONTROL + "v");
	}
	
	
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//moueOverElement("nav-link-accountList-nav-line-1");
		//dragAndDropElement("draggable", "droppable");
		//slidebarElement("slider", "demo-frame");
		//rightClick("Draggable");
		//doubleClick("twotabsearchtextbox");
		//keyEnter("twotabsearchtextbox");
		//keyTab("email");
		selectAll("email", "pass");
	}

}
