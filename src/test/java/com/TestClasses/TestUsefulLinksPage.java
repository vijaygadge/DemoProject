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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.TestBase.TestBase;

import jbk.pages.DashboardPage;
import jbk.pages.UsefulLinksPage;

public class TestUsefulLinksPage extends TestBase
{
	WebDriver driver;
	DashboardPage dp=null;
	UsefulLinksPage ul=null;
	@BeforeSuite
	public void setUp()
	{
		driver=initialization();
		log=Logger.getLogger(TestUsefulLinksPage.class);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		dp=new DashboardPage(driver);
		ul=dp.clickOnUsefulLinksPage();
		log.info("UsefulLinksPage initialized");
	}
	@AfterSuite()
	public void close()
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"JavaByKiran | Useful Links");
		log.info("verifyTitle()->passed");		
	}
	
	@Test(priority=2,dependsOnMethods="verifyTitle")
	public void varifyUsersText()
	{
		String h1 = ul.headingText();
		String h="Useful Links";
		Assert.assertEquals(h1,h);
		log.info("varifyUsersText()->passed");
	}
	
	@Test(priority=3,dependsOnMethods="verifyTitle")
	public void varifyHome()
	{
		String home = ul.olTagText();
		String home2="Home Useful Links";
		Assert.assertEquals(home,home2);
		log.info("varifyHome()->passed");
	}
	
	@Test(priority=4,dependsOnMethods="verifyTitle")
	public void varifyJBKTextInNavBar()
	{
		String A = ul.jbkText();
		String B="Java By Kiran";
		Assert.assertEquals(A,B);
		log.info("varifyJBKTextInNavBar()->passed");
	}
	
	@Test(priority=5,dependsOnMethods="verifyTitle")
	public void varifyLeftBar()// The whole LHS Navigation Bar
	{
		String A = ul.LHSNavBar();
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
		log.info("varifyLeftBar()->passed");
	}
	
	@Test(priority=6,dependsOnMethods="verifyTitle")
	public void varifyFooter()
	{
		String t1= ul.verifyFooter();
		String t2="Design for Selenium Automation Test V 2.3.0\n" + 
				"Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		Assert.assertEquals(t1,t2);
		log.info("varifyFooter()->passed");
	}
	
	@Test(priority=7)
	public void varifyLogoutText()
	{	
		String logout =ul.verifyLogout();
		String logout2="LOGOUT";
		Assert.assertEquals(logout,logout2);
		log.info("varifyLogoutText()->passed");
	}
	
	@Test(priority=8)
	public void varifyUserListText()
	{	
		String text1=ul.verifyUserListText();
		String text2="* Internet Required";
		Assert.assertEquals(text1,text2);
		log.info("varifyUserListText()->passed");
	}
	
	@Test(priority=9,dependsOnMethods="verifyTitle")
	public void clickHome()
	{
		ul.clickHome();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/links.html#");
		log.info("clickHome()->passed");
	}
	
	@Test(priority=10,dependsOnMethods="verifyTitle")
	public void clickJBKTextInNavBar()
	{
		//driver.findElement(By.xpath("//b[text()='Java By Kiran']")).click();
		ul.clickjbkText();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html");
		driver.navigate().back();
		log.info("clickJBKTextInNavBar()->passed");
	}
	
	@Test(priority=11,dependsOnMethods="verifyTitle")
	public void clickOnlineText()// The whole LHS Navigation Bar
	{
		ul.clickOnlineText();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/links.html#");
		log.info("clickOnlineText()->passed");
	}
	
	@Test(priority=12,dependsOnMethods="verifyTitle")
	public void clickFooter() throws InterruptedException// The whole LHS Navigation Bar
	{
		String link1="https://www.javabykiran.com/";
		String parentId=driver.getWindowHandle();
		System.out.println("Parent URL :"+driver.getCurrentUrl());

		ul.clickFooter();
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
	
	@Test(priority=13)
	public void clickIMG() throws AWTException
	{
		Actions act=new Actions(driver);
		WebElement logo=ul.getIMG();
		act.contextClick(logo).perform();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		log.info("clickIMG()->passed");
	}
	
	@Test(priority=14)
	public void verifyTextInTable() throws Exception
	{	
		ul.textInTable();
		log.info("verifyTextInTable()->passed");
	}
	
	@Test(priority=15)
	public void clickLogout()
	{	
		ul.clickLogout();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/logout.html");
		log.info("clickLogout()->passed");
	}
	
	@Test(priority=16,dependsOnMethods="clickLogout")
	public void verifyLogoutText()
	{	
		String logoutText=ul.logoutText();
		Assert.assertEquals(logoutText,"Logout successfully");
		log.info("verifyLogoutText()->passed");
	}
}
