package TestCases;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import Utilities.ReadConfig;
import Utilities.helperClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass implements ITestListener {
	
	ReadConfig cf = new ReadConfig();
	public  String url =cf.GetUrl();
	public String username = cf.GetUsername();
	public String password=cf.GetPassword();
	public static  WebDriver driver ;
	public static Logger logger ;
	public static ExtentReports extent;
	public static  ExtentTest extentlogger;
	public ExtentHtmlReporter reporter;
	public static Alert alert;
	
	
	@BeforeSuite
	public void SetUp()
	{

	
		logger = Logger.getLogger("E-Banking_Project");
		PropertyConfigurator.configure("log4j.properties");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		//Report Creation
		 reporter= new ExtentHtmlReporter("./reports/"+timestamp+"ExtentReportResults.html");
	     extent=new ExtentReports();
	     extent.attachReporter(reporter);
	   
	}
	
	
	@BeforeMethod
	public void onTestStart(ITestResult result) {
		
		System.setProperty("webdriver.chrome.driver",cf.GetChromeDriver());
		driver= new ChromeDriver();
		logger.info("Opened Browser Successfully !");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	    logger.info("Test Started Successfully !");
		 
	}
	
	@AfterMethod()
	public   void  onTestSuccess(ITestResult result) {
		    if(result.getStatus()==result.SUCCESS)
				{
			logger.info("Testcase Passed Successfully ! "+ result.getName() );
			extentlogger.log(Status.PASS, "Test Case Passes in Extent Report");
				driver.quit();
			    logger.info("Browser Quit Successfully  After Success!");
				}
		   
		
		
	}
	
	@AfterMethod
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==result.FAILURE)
		{
	logger.info("OOPS! Testcase has been  Failed");
	extentlogger.log(Status.FAIL, "Test Case Failed in Extent Report");
	try {
		helperClass.ScreenShot(driver);
		logger.info("Screenshot captured for failed Test Case");
	} catch (IOException e) {
		
		e.printStackTrace();
		logger.info("Screenshot Failed for failed Test Case");
	}
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.quit();
	logger.info("Browser Quit Successfully  After Failure!");
	
	
		}
		
	}
	@AfterMethod
	public   void  onTestSkip(ITestResult result) throws InterruptedException {
		
		if(result.getStatus()==result.SKIP)
				{
			logger.info("Testcase Skipped !");
			extentlogger.log(Status.SKIP, "Test Case Skipped in Extent Report");
			driver.quit();
			logger.info("Browser Quit Successfully After Skippped!");
				}
		
		
	}
	
	
	@AfterSuite
	public void TearDown() throws InterruptedException
	{
		
		extent.flush();
   		
	}
	

}
