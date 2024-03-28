package screenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy3 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		String text1 = driver.findElement(By.linkText("Customer Service")).getText();
		System.out.println(text1);
		
		System.out.println(" --------------------------------------------   ");
		
		
		List<WebElement> text2 = driver.findElements(By.tagName("a"));
		for(int i=0;i<text2.size();i++)
		{
			System.out.println(text2.get(i).getText());
		}
		
		System.out.println(" --------------------------------------------   ");
		
		List<WebElement> text3 = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		for(int j=0;j<text3.size();j++)
		{
			System.out.println(text3.get(j).getText());
		}
	}

}
