package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.common.io.Files;

public class helperClass {

	public static void ScreenShot(WebDriver driver ) throws IOException
	{ 
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File source_file=screenshot.getScreenshotAs(OutputType.FILE);
	File destination_File= new File("./Screenshot/"+"FailedTest"+" "+timestamp+".png");
	Files.copy(source_file, destination_File);
		
		
	} 
	
	
	
}
