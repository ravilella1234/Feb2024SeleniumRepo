package com.selenium.project;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		driver.manage().window().maximize();
		
		selectOption("amazonsearchdropbox_id","Books");
		
		typeText("amazonsearchtext_name","Harry Potter");
		
		clickElement("amazonserachbutton_xpath");
		
		
		
		/*WebElement loc = driver.findElement(By.id("searchDropdownBox"));	
		loc.sendKeys("Books");
		
		driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();*/
	}

	

}
