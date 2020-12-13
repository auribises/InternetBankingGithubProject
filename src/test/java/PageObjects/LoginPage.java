package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage (WebDriver local_driver)
	{
		driver= local_driver;
		PageFactory.initElements(local_driver, this);
	}

	@FindBy(name ="uid")
	WebElement userName;
	
	
	@FindBy(name ="password")
	WebElement userPassword;
	
	@FindBy(name ="btnLogin")
	WebElement loginButton;
	
	@FindBy(linkText="Log out")
	WebElement logoutlink;
	
	public void SetCredebtials(String username, String password) throws InterruptedException
	{
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);
	}
	
	public void LogOut() throws InterruptedException
	{
		logoutlink.click();
		Thread.sleep(2000);
		
		
	}
	
	
}
