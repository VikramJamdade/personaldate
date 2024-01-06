package com.traval.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseGD

{
	
	public static WebDriver driver;
	public static String ImpliWait ;
	public static Properties propT;
	
	
	public TestBaseGD() 
	
	{
		
		try 
		{
			//To take the details from configuration file
			propT = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\G-Traval\\src\\main\\java\\com\\traval\\qa\\confiq\\Configure.propertiesforTraval");
		
			
			propT.load(ip);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void implicitewait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(com.traval.qa.utility.TestUtilGD.IMPLICITE_WAIT));
	}
		@SuppressWarnings("deprecation")
		public static void initialization1(){
			String browserName = propT.getProperty("browser");
		    driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts(). pageLoadTimeout(com.traval.qa.utility.TestUtilGD.PAGE_LOAD_TIMEOUT, TimeUnit. SECONDS);
			//ImpliWait	= "driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(com.traval.qa.utility.TestUtilGD.IMPLICITE_WAIT))
			implicitewait();
			driver.get(propT.getProperty("URL"));	
	}
	
	
}
