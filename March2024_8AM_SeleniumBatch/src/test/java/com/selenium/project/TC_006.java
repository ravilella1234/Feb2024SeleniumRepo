package com.selenium.project;

import com.aventstack.extentreports.Status;

public class TC_006 extends BaseTest
{
		
	public static void main(String[] args) throws Exception 
	{
		
		init();
		test = report.createTest("TC_006");
		test.log(Status.INFO, "Init the properties files...");	
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opened the browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigated to application : " + childprop.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
		
		selectOption("amazonsearchdropbox_id","Books");
		test.log(Status.FAIL, "selected the option Books By using locator : " + orProp.getProperty("amazonsearchdropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered text Harry potter By ung the locator : " +  orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonserachbutton_xpath");
		test.log(Status.PASS, "Clicked the element By uing locator : " +  orProp.getProperty("amazonserachbutton_xpath"));
		
		report.flush();
		
	}
}
