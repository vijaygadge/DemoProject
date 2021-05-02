package com.TestClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import jbk.pages.DownloadsPage;
import jbk.pages.DashboardPage;

public class TestDownloadsPage extends TestBase
{
	WebDriver driver;
	DashboardPage dap=null;
	DownloadsPage dp=null;
	private Logger log=Logger.getLogger(TestDownloadsPage.class);
	
	@BeforeTest
	public void setdp()
	{
		driver=initialization();
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		dap=new DashboardPage(driver);
		dp=dap.clickOnDownloadsPage();
		log.info("DashboardPage initialized");
	}
	@AfterTest()
	public void close()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"JavaByKiran | Downloads");
	}
	
	@Test(priority=2,dependsOnMethods="verifyTitle")
	public void varifyUsersText()
	{
		String h1 = dp.headingText();
		String h="Downloads";
		Assert.assertEquals(h1,h);
	}
	
	@Test(priority=3,dependsOnMethods="verifyTitle")
	public void varifyHome()
	{
		String home = dp.olTagText();
		String home2="Home Downloads";
		Assert.assertEquals(home,home2);
	}
	
	@Test(priority=4,dependsOnMethods="verifyTitle")
	public void varifyJBKTextInNavBar()
	{
		String A = dp.jbkText();
		String B="Java By Kiran";
		Assert.assertEquals(A,B);
	}
	
	@Test(priority=5,dependsOnMethods="verifyTitle")
	public void varifyLeftBar()// The whole LHS Navigation Bar
	{
		String A = dp.LHSNavBar();
		String B="Kiran\n" + 
				"Online\n" + 
				"MAIN NAVIGATION\n" + 
				"Dashboard\n" + 
				"Users\n" + 
				"Operators\n" + 
				"Useful Links\n" + 
				"Downloads\n" + 
				"Logout";
		Assert.assertEquals(A,B);
	}
	
	@Test(priority=6,dependsOnMethods="verifyTitle")
	public void varifyFooter()
	{
		String t1= dp.verifyFooter();
		String t2="Design for Selenium Automation Test V 2.3.0\n" + 
				"Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		Assert.assertEquals(t1,t2);
	}
	
	@Test(priority=7)
	public void varifyLogoutText()
	{	
		String logout =dp.verifyLogout();
		String logout2="LOGOUT";
		Assert.assertEquals(logout,logout2);
	}
	
	@Test(priority=8)
	public void varifyDownloadsListText()
	{	
		String text1=dp.verifyUserListText();
		String text2="Downloads List";
		Assert.assertEquals(text1,text2);
	}
	
	@Test(priority=9)
	public void clickLogoIMG() throws AWTException
	{
		Actions act=new Actions(driver);
		WebElement logo=dp.getIMG();
		act.contextClick(logo).perform();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	@Test(priority=10)
	public void verifyTextInTable()
	{	
		dp.textInTable();
	}
	
	@Test(priority=11)
	public void clickImages() throws AWTException
	{	
		dp.getImages();
	}
	
	@Test(priority=12,dependsOnMethods="verifyTitle")
	public void clickHome()
	{
		dp.clickHome();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C:/Offline%20Website/Offline%20Website/pages/examples/downloads.html#");
	}
	
	@Test(priority=13,dependsOnMethods="verifyTitle")
	public void clickJBKTextInNavBar()
	{
		//driver.findElement(By.xpath("//b[text()='Java By Kiran']")).click();
		dp.clickjbkText();
		String actual=driver.getCurrentUrl();
		driver.navigate().back();
		Assert.assertEquals(actual,"file:///C:/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
	}
	
	@Test(priority=14,dependsOnMethods="verifyTitle")
	public void clickOnlineText()// The whole LHS Navigation Bar
	{
		dp.clickOnlineText();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C:/Offline%20Website/Offline%20Website/pages/examples/downloads.html#");
	}
	
	@Test(priority=15,dependsOnMethods="verifyTitle")
	public void clickFooter() throws Exception// The whole LHS Navigation Bar
	{
		String link1="https://www.javabykiran.com/";
		String parentId=driver.getWindowHandle();
		System.out.println("Parent URL :"+driver.getCurrentUrl());

		dp.clickFooter();
		Set<String> s=driver.getWindowHandles();
		for(String str: s)
		{
			if(!str.equals(parentId))
			{
				driver.switchTo().window(str);
				String url2=driver.getCurrentUrl();
				System.out.println("child URL :"+url2);
				if(url2.equals(link1))
				{
					Assert.assertEquals(url2, link1);
					Thread.sleep(1000);
					driver.close();
					driver.switchTo().window(parentId);
				}
				else
				{
					driver.close();
					driver.switchTo().window(parentId);
				}
			}
		}
	}
	
	@Test(priority=16)
	public void clickLogout()
	{	
		dp.clickLogout();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C:/Offline%20Website/Offline%20Website/pages/examples/logout.html");
	}
	
	@Test(priority=17,dependsOnMethods="clickLogout")
	public void verifyLogoutText()
	{	
		String logoutText=dp.logoutText();
		Assert.assertEquals(logoutText,"Logout successfully");
	}
}
