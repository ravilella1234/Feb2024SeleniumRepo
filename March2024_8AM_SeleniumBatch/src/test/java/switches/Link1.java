package switches;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link1 
{

	public static void main(String[] args) throws Exception 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		// Getting All The Links In One List 
	    List <WebElement>links =  driver.findElements(By.tagName("a")); 
	      
	    // Printing The Total Links Number 
	    System.out.println("Total Link Size: " +  links.size()); 
	    for(int i = 0; i < links.size(); i++) 
	    { 
	      // Checking Each & Every Links 
	      WebElement element = links.get(i); 
	          
	      String url = element.getAttribute("href"); 
	  
	      URL link = new URL(url); 
	      HttpURLConnection httpConn =  (HttpURLConnection) link.openConnection(); 
	      httpConn.connect(); 
	          
	      // Getting The Response Code 
	      int code = httpConn.getResponseCode(); 
	          
	      // If The Number Is Greater Than 400,  
	      // Then It Is Broken Link 
	      if(code >= 400) 
	      { 
	        System.out.println("Broken Link: " +  url); 
	      } 
	      else
	      { 
	        System.out.println("Valid Link: " +  url); 
	      }     
	    } 
	      
	    System.out.println(); 
	    System.out.println("All Links Checked"); 
	      
	    // Closing The Driver 
	    driver.quit();     
	}

}
