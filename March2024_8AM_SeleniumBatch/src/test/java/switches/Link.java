package switches;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link 
{

	public static void main(String[] args) throws Exception 
	{
		
		//https://toolsqa.com/selenium-webdriver/find-broken-links-in-selenium/
		//https://testsigma.com/blog/broken-links-in-selenium/
		//https://www.geeksforgeeks.org/how-selenium-webdriver-can-be-used-to-detect-broken-links/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//get the list of all links
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links are : " +  links.size());
		
		List<String> urllist = new ArrayList<String>();
		
		//iterate linkslist
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null)
			{
				urllist.add(urllist.get(i));
			}
		}
		
		//get the size of active links list
		System.out.println("size of active links are :" + urllist.size());
		
		
	
	}
	
	public static void checkBrokenLink(String linkurl) throws Exception
	{
		try 
		{
			URL url = new URL(linkurl);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode() >= 400)
			{
				System.out.println(linkurl + "--->"+ httpURLConnection.getResponseMessage() + "is a broken link");
			}
			else
			{
				System.out.println(linkurl + "--->"+ httpURLConnection.getResponseMessage());
			}
		} 
		catch (MalformedURLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

}
