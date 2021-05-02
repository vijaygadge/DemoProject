package com.TestClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
import jbk.pages.UsersPage;

public class TestUsersPage extends TestBase
{
	WebDriver driver;
	UsersPage up=null;
	DashboardPage dp=null;
	private Logger log=Logger.getLogger(TestUsersPage.class);
	
	@BeforeSuite
	public void setUp()
	{
		driver=initialization();
		log=Logger.getLogger(TestUsersPage.class);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		dp=new DashboardPage(driver);
		up=dp.clickOnUserPageLink();
		log.info("UserPage initialized");
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
		Assert.assertEquals(title,"JavaByKiran | User");
	}
	
	@Test(priority=2,dependsOnMethods="verifyTitle")
	public void varifyUsersText()
	{
		String h1 = up.headingText();
		String h="Users";
		Assert.assertEquals(h1,h);
	}
	
	@Test(priority=3,dependsOnMethods="verifyTitle")
	public void varifyHome()
	{
		String home = up.olTagText();
		String home2="Home Users";
		Assert.assertEquals(home,home2);
	}
	
	@Test(priority=4,dependsOnMethods="verifyTitle")
	public void varifyJBKTextInNavBar()
	{
		String A = up.jbkText();
		String B="Java By Kiran";
		Assert.assertEquals(A,B);
	}
	
	@Test(priority=5,dependsOnMethods="verifyTitle")
	public void varifyLeftBar()// The whole LHS Navigation Bar
	{
		String A = up.LHSNavBar();
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
		String t1= up.verifyFooter();
		String t2="Design for Selenium Automation Test V 2.3.0\n" + 
				"Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		Assert.assertEquals(t1,t2);
	}
	
	@Test(priority=7)
	public void varifyLogoutText()
	{	
		String logout =up.verifyLogout();
		String logout2="LOGOUT";
		Assert.assertEquals(logout,logout2);
	}
	
	@Test(priority=8)
	public void varifyUserListText()
	{	
		String text1=up.verifyUserListText();
		String text2="User List";
		Assert.assertEquals(text1,text2);
	}
	
	@Test(priority=9)
	public void varifyAddUser()
	{
		// To click Add User
		String t1=up.verifyAddUserText();
		String t2="Add User";
		Assert.assertEquals(t1,t2);
	}
	
	@Test(priority=10)
	public void varifyDeleteDefaultUser()
	{
		String d1=up.verifydeleteText();
		String d2="Delete";
		Assert.assertEquals(d1,d2);
	}
	
	@Test(priority=11,dependsOnMethods="verifyTitle")
	public void clickHome()
	{
		up.clickHome();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/users.html#");
	}
	
	@Test(priority=12,dependsOnMethods="verifyTitle")
	public void clickJBKTextInNavBar()
	{
		//driver.findElement(By.xpath("//b[text()='Java By Kiran']")).click();
		up.clickjbkText();
		String actual=driver.getCurrentUrl();
		driver.navigate().back();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html");
	}
	
	@Test(priority=13,dependsOnMethods="verifyTitle")
	public void clickOnlineText()// The whole LHS Navigation Bar
	{
		up.clickOnlineText();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/users.html#");
	}
	
	@Test(priority=14)
	public void clickDeleteDefaultUser() throws InterruptedException
	{
		//To Delete User
		up.clickDelete();
		Alert al=driver.switchTo().alert();
		Thread.sleep(1000);
		al.accept();// to click on OK
	}
	
	@Test(priority=15)
	public void clickNormalUserToDelete() throws InterruptedException
	{
		//To Delete User
		up.clickDeleteNormalUser();
		Alert al=driver.switchTo().alert();
		Thread.sleep(1000);
		al.accept();// to click on OK
		al.accept();// to click on OK
	}
	
	@Test(priority=16)
	public void clickIMG() throws Exception
	{
		Actions act=new Actions(driver);
		WebElement logo=up.getIMG();
		act.contextClick(logo).perform();
		Thread.sleep(1000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	@Test(priority=17)
	public void verifyTextInTable()
	{
		up.textInTable();
	}
	
	@Test(priority=18)
	public void verifytoggleElementText() throws InterruptedException
	{
		String t1=up.toggleElementText();
		System.out.println("Tooltip Text : "+t1);
		String t2="Click to Delete";
		Assert.assertEquals(t1,t2);
	}
	
	@Test(priority=19)
	public void verifyAllLinks_SwitchOnLinks() throws Exception
	{
		String link1="https://www.javabykiran.com/";
		String parentURL=driver.getWindowHandle();
		System.out.println("Parent URL :"+driver.getCurrentUrl());

		up.clickFooter();
		Set<String> s=driver.getWindowHandles();
		for(String str: s)
		{
			if(!str.equals(parentURL))
			{
				driver.switchTo().window(str);
				String url2=driver.getCurrentUrl();
				System.out.println("child URL :"+url2);
				if(url2.equals(link1))
				{
					Assert.assertEquals(url2, link1);
					Thread.sleep(1000);
					driver.close();
					driver.switchTo().window(parentURL);
				}
				else
				{
					driver.close();
					driver.switchTo().window(parentURL);
				}
			}
		}
	}
	
	@Test(priority=20)
	public void clickLogout()
	{	
		up.clickLogout();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/logout.html");
	}
	
	@Test(priority=21,dependsOnMethods="clickLogout")
	public void verifyLogoutText()
	{	
		String logoutText=up.logoutText();
		Assert.assertEquals(logoutText,"Logout successfully");
	}
}
