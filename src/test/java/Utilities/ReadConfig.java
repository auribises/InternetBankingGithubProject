package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public static Properties properties;
	
	public ReadConfig() 
	{
		
		
		try {
			   File file= new File("C:\\Users\\GPS\\workspace\\E-Banking_Project\\Configuration\\config.properties");
			   FileInputStream    fis = new FileInputStream(file);
			   properties= new Properties();
			   properties.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Exception Got Caught ");
		}
				
	}

	public String GetChromeDriver()
	{
		return properties.getProperty("chrome_path");
	}
	public String GetIEDriver()
	{
		return properties.getProperty("ie_path");
	}
	public String GetUrl() {
		return properties.getProperty("url");
	}
	public String GetUsername() {
		return properties.getProperty("username");
	}
	public String GetPassword() {
		return properties.getProperty("password");
	}

}
