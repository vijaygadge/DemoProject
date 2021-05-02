package com.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
public class TestBase 
{
	public static WebDriver driver=null;
	public static Logger log=null;
	public TestBase()
	{
		log=Logger.getLogger(TestBase.class);
	}
	
	public String readProperty(String key)
	{
		Properties prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	public WebDriver initialization()
	{
		try
		{
			log.info("Initializing Browser");
			System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Chrome Browser Opened");
				driver.manage().window().maximize();
		}catch(Exception e)
		{
			log.info(e.getMessage());
			log.info(e.getClass().getName());
			log.info("Chrome Driver File is not available");
		}
			driver.get(readProperty("url"));
			log.info("JBK Offline Application URL Launched");
			return driver;
		
	}
	
}
