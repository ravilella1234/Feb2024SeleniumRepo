package com.selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExample 
{
	
    public static void main(String[] args) 
    {
       
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try 
        {
            // Open the website
            driver.get("https://www.amazon.in/");

            WebElement element = findElementById(driver, "twotabsearchtextbo");
            if (element != null) 
            {
                System.out.println("Element found: " + element.getText());
            } 
            else 
            {
                System.out.println("Element not found.");
            }

            // Perform other actions as needed
        } 
        finally 
        {
            driver.quit();
        }
    }

    // User-defined method to find element by ID
    public static WebElement findElementById(WebDriver driver, String elementId) 
    {
        try 
        {
            // Attempt to find the element by ID
            WebElement element = driver.findElement(By.id(elementId));
            return element; // Return the element if found
        } 
        catch (NoSuchElementException e) 
        {
            return null; // Return null if element not found
        }
    }
}