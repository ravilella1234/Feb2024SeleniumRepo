package alertsitches;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicCamNotification 
{

	public static void main(String[] args) 
	{
		// INIT CHROME OPTIONS
	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	   
	    
	    // SET CHROME OPTIONS
	    // 0 - Default, 1 - Allow, 2 - Block
	    // contentSettings.put("notifications", 2);
	  
	     prefs.put("profile.default_content_setting_values.media_stream_mic", 0);
	     //prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
	     //prefs.put("profile.default_content_setting_values.geolocation", 0);
	     //prefs.put("profile.default_content_setting_values.notifications", 1);
	     options.setExperimentalOption("prefs", prefs);
		
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//geo location
		/*driver.get("https://the-internet.herokuapp.com/geolocation");
		driver.findElement(By.xpath("//button[text()='Where am I?']")).click();*/
	    
		//mic
	    driver.get("https://www.vidyard.com/mic-test/");
	    driver.findElement(By.xpath("//button[text()='Start mic Test']")).click();
	}

}
