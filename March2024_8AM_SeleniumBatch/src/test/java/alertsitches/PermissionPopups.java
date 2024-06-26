package alertsitches;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopups 
{

	public static void main(String[] args) throws Exception 
	{
		
		// INIT CHROME OPTIONS
	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    Map<String, Object> profile = new HashMap<String, Object>();
	    Map<String, Object> contentSettings = new HashMap<String, Object>();
	    
	    // SET CHROME OPTIONS
	    // 0 - Default, 1 - Allow, 2 - Block
	    // contentSettings.put("notifications", 2);
	    contentSettings.put("geolocation", 2);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
		
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/geolocation");
		
	    driver.findElement(By.xpath("//button[text()='Where am I?']")).click();
	}
}
