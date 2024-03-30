package com.selenium.project;

import org.apache.log4j.Logger;

public class TC_004 extends BaseTest
{
	
	private static final Logger log = Logger.getLogger(TC_004.class);
	
	public static void main(String[] args) throws Exception 
	{
		
		init();
		log.info("Init the properties files...");		
		
		launch("chromebrowser");
		log.info("Opened the browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to application : " + childprop.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
		
		selectOption("amazonsearchdropbox_id","Books");
		log.info("selected the option Books By using locator : " + orProp.getProperty("amazonsearchdropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		log.info("Entered text Harry potter By ung the locator : " +  orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonserachbutton_xpath");
		log.info("Clicked the element By uing locator : " +  orProp.getProperty("amazonserachbutton_xpath"));
		
		
		
		
		/*WebElement loc = driver.findElement(By.id("searchDropdownBox"));	
		loc.sendKeys("Books");
		
		driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();*/
	}

	

}
