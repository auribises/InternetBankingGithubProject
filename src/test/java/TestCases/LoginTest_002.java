package TestCases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.ExcelReader;
import Utilities.helperClass;
import junit.framework.Assert;

public class LoginTest_002 extends BaseClass  {
	
	@Test(dataProvider="dp")
	public void DataDriven(String username , String password) throws InterruptedException, IOException
	{
		extentlogger = extent.createTest(" DataDriven "+username);
		
		driver.get(url);
		logger.info("url opened successfully");
		LoginPage lp= new LoginPage(driver);
		lp.SetCredebtials(username, password);

		if(CheckAlert()==true)
		{
			logger.info("Login Failed");
		
			alert.accept();
			driver.switchTo().defaultContent();
		
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Sucessfully!");
			
		}
		
		
	}
	
	
	
	@DataProvider(name="dp")
	public Object[][] GetData() throws IOException
	{
		int row = ExcelReader.CountRow( 0);
		int col = ExcelReader.CountCell( 0, 0);
		Object[][] data = new Object[row][col];
		 
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data[i][j] =ExcelReader.ReadData(0,i,j);
				System.out.print(data[i][j] +  "   ");
			}
			System.out.println();
		}
		
		return data;
	}
	
	public static boolean CheckAlert()
	{
	try {
		  alert = driver.switchTo().alert();
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}
	

}
