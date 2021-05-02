package com.TestClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.TestBase.TestBase;

public class TestIndexPage1 extends TestBase
{
	private Logger log=Logger.getLogger(TestIndexPage1.class);
	WebDriver driver=null;
	@Test
	public void login()
	{
		driver=initialization();
		driver.findElement(By.id("email")).sendKeys(readProperty("uname"));
		driver.findElement(By.id("password")).sendKeys(readProperty("pass"));
		driver.findElement(By.xpath("//button")).click();
		log.info("User Successfully login into the Application");
		driver.close();
	}
}
