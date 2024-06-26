package excelDataDriven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class FaceBookFinalProgram 
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> obj) 
  {
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys(obj.get("UserName"));
		driver.findElement(By.id("pass")).sendKeys(obj.get("UserPassword"));
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "LoginTest";
		return DataUtil.getTableData(e, sheetName, testName);
  }
}
