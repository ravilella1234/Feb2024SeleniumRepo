package browserOptions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxOptionDemo 
{

	public static void main(String[] args) 
	{
		
		FirefoxOptions option = new FirefoxOptions();
		//option.addArguments("--headless");
		//option.addArguments("--private");
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile profile = p.getProfile("May2024FF");
			
		//webnotification handling
		profile.setPreference("dom.webnotifications.enabled", false);
		
		//To ignore certificate error
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		//working with proxy setting
		//profile.setPreference("network.proxy.type", 1);
		//profile.setPreference("network.proxy.socks", "19.168.10.1");
		//profile.setPreference("network.proxy.socks_port", 1744);
		
		option.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(option);
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		
		driver.get("https://www.axisbank.com/");
		//driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
