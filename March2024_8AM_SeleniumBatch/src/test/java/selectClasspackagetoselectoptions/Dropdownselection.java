package selectClasspackagetoselectoptions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdownselection 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		Select obj = new Select(loc);
		/*obj.selectByIndex(11);
		Thread.sleep(2000);
		obj.selectByVisibleText("Baby");
		Thread.sleep(2000);
		obj.selectByValue("search-alias=amazon-pharmacy");
		
		List<WebElement> options = obj.getOptions();
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
		
		System.out.println(obj.getFirstSelectedOption().getText());*/
		
		obj.selectByIndex(11);
		Thread.sleep(2000);
		obj.deselectByVisibleText("Books");
		
	}

}
