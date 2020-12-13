package TestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.LoginPage;
import Utilities.helperClass;

public class LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws IOException, InterruptedException
	{
		extentlogger=extent.createTest("LoginTest");
		driver.get(url);
		logger.info("url opened successfully");
		LoginPage lp = new LoginPage(driver);
		lp.SetCredebtials(username, password);
			logger.info("Login successfully");
		
			
			
		}
		
		
		
		
	}
	
	

