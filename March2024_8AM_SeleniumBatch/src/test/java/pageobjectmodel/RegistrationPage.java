package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage 
{
	@FindBy(id="reg_email") WebElement userEmail;
	@FindBy(id="reg_password") WebElement userPassword;
	@FindBy(name="register") WebElement regiterButton;
	
	
	public RegistrationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public void customerRegistration()
	{
		userEmail.sendKeys("ravilella.1981@gmail.com");
		userPassword.sendKeys("pass");
		//regiterButton.click();
	}
	
	
}
