package com.selenium.project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboDepartureTest 
{
    public static void main(String[] args) throws Exception 
    {
     
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.goibibo.com/");
       driver.manage().window().maximize();
       Thread.sleep(3000);
       driver.findElement(By.className("logSprite icClose")).click();

        // Find and click on the departure field
        WebElement departureField = driver.findElement(By.xpath("//span[text()='Departure']"));
        departureField.click();
        List<WebElement> months = driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div/div[1]/div"));
        for(int i=1;i<=months.size()+1;i++)
        {
        	if(!months.get(i).getText().equals("August 2024"))
        	{
        		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        	}
        }
        
        // Select month and date
        /*WebElement nextMonthArrow = driver.findElement(By.xpath("//div[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
        nextMonthArrow.click(); // Click to navigate to next month

        
        // Find and select the desired date
        WebElement dateElement = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]//div[@aria-label='Choose Monday, March 25th, 2024']")); // Adjust the XPath according to the desired date
        dateElement.click(); // Click to select the date

        driver.quit();*/
    }
}
