package com.TestClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;

import com.TestBase.TestBase;
import jbk.pages.AddUserPage;
import jbk.pages.UsersPage;

public class TestAddUserPage extends TestBase
{
	WebDriver driver;
	AddUserPage aup=null;
	UsersPage up=null;
	@BeforeSuite
	public void setup()
	{
		driver=initialization();
		log=Logger.getLogger(TestAddUserPage.class);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		up=new UsersPage(driver);
		up.clickOnUserPageLink();
		aup=up.clickAddUser();
		//aup=new AddUserPage(driver);
		log.info("AddUserPage initialized");
	}
	@AfterSuite()
	public void close()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"JavaByKiran | Add User");
		log.info("verifyTitle()->passed");
	}
	
	@Test(priority=2,dependsOnMethods="verifyTitle")
	public void varifyHome()
	{
		String home = aup.olTagText();
		String home2="Home Add User";
		aup.clickHome();
		Assert.assertEquals(home,home2);
		log.info("varifyHome()->passed");
	}
	
	@Test(priority=3,dependsOnMethods="verifyTitle")
	public void clickHome()
	{
		aup.clickHome();
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url,"file:///C://Offline%20Website//Offline%20Website/pages/examples/add_user.html#");
		log.info("clickHome()->passed");
	}
	
	@Test(priority=4,dependsOnMethods="verifyTitle")
	public void varifyJBKTextInNavBar()
	{
		String A = aup.jbkText();
		String B="Java By Kiran";
		Assert.assertEquals(A,B);
		log.info("varifyJBKTextInNavBar()->passed");
	}
	
	@Test(priority=5,dependsOnMethods="verifyTitle")
	public void clickJBKTextInNavBar()
	{
		aup.clickjbkText();
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url,"file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html");
		driver.navigate().back();
		log.info("clickJBKTextInNavBar()->passed");
	}
	
	@Test(priority=6,dependsOnMethods="verifyTitle")
	public void varifyLeftBar()// The whole LHS Navigation Bar
	{
		String A = aup.LHSNavBar();
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
	
	@Test(priority=7,dependsOnMethods="verifyTitle")
	public void clickOnlineText()
	{
		aup.clickOnlineText();
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url,"file:///C://Offline%20Website//Offline%20Website/pages/examples/add_user.html#");
		log.info("clickOnlineText()->passed");
	}
	
	@Test(priority=8,dependsOnMethods="verifyTitle")
	public void varifyFooter()
	{
		String t1= aup.verifyFooter();
		String t2="Version 2.3.0\n" + 
				"Copyright © 2014-2015 JBK. All rights reserved.";
		Assert.assertEquals(t1,t2);
		log.info("varifyFooter->passed");
	}
	
	@Test(priority=9,dependsOnMethods="verifyTitle")
	public void clickFooterLink()
	{
		aup.clickFooter();
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url,"http://jbk.com/");
		driver.navigate().back();
		log.info("clickFooterLink()->passed");
	}
	
	@Test(priority=10)
	public void varifyLogoutText()
	{	
		String logout =aup.verifyLogout();
		String logout2="LOGOUT";
		Assert.assertEquals(logout,logout2);
		log.info("varifyLogoutText()->passed");
	}
	
	@Test(priority=11)
	public void varifyAddUserText()
	{
		String t1=aup.verifyAddUserText();
		String t2="Add User";
		Assert.assertEquals(t1,t2);
		log.info("varifyAddUser()->passed");
	}

	@Test(priority=12)
	public void verifyh3Text()
	{
		String t1=aup.verifyh3Text();
		String t2="Fill Below Details";
		Assert.assertEquals(t1,t2);
		log.info("verifyh3Text()->passed");
	}
	
	@Test(priority=13,dataProvider="loginData")
	public void varifyAddUser(String UserName,String Mobile,String Email,String Courses,String Gender,String State,String Password)
		{
			
			aup.setUserName(UserName);
			aup.setMobileNo(Mobile);
			aup.setEmail(Email);
			aup.setCourse(Courses);
			//		For Selecting Radio Button
					if(Gender.equals("Male"))
					{
						aup.setMale();
					}
					else 
					{
						aup.setFemale();
					}
					
			//		For Selecting Select Box
			Select state=new Select(aup.setSelect());
			state.selectByVisibleText(State);	
		
			aup.setPassword(Password);
				
			driver.findElement(By.id("submit")).click();
			Alert al=driver.switchTo().alert();
			al.accept();// to click on OK
			log.info("varifyAddUser()->passed");
			
		}
		@DataProvider
		public Object[][] loginData() throws Exception
		{
			FileInputStream fis=null;
			Workbook wb=null;
			Sheet sh=null;
			try {
			 log.warn("File should be present at location");
			 fis=new FileInputStream("src\\test\\resources/TestData.xls");
			 wb=Workbook.getWorkbook(fis);
			 sh=wb.getSheet("UserPageData");
			}catch(Exception e)
			{
				log.info(e.getMessage());
				log.info(e.getClass().getName());
				log.error("Unable to right click and press enter on \"Open image in new Tab\"");
			}
			String dataArr[][]=new String[sh.getRows()-1][sh.getColumns()];//[]
			
			//getRows() returns total No.Of Rows in the Sheet
			for(int i=1;i<sh.getRows();i++)//To Skip Reading 1st Row
			{
				for(int j=0;j<sh.getColumns();j++)
				{
					String data=sh.getCell(j,i).getContents();
					dataArr[i-1][j]=data;
				}
			}
			return dataArr;
		}
		
	@Test(priority=14)
	public void clickIMG() throws AWTException
	{
		try {
		Actions act=new Actions(driver);
		WebElement logo=aup.getIMG();
		act.contextClick(logo).perform();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_ENTER);
		}catch(Exception e)
		{
			log.info(e.getMessage());
			log.info(e.getClass().getName());
			log.error("Unable to right click and press enter on \"Open image in new Tab\"");
		}
	}
	
	@Test(priority=15)
	public void cancleBtn()
	{	
		aup.cancleBtn();
		log.info("cancleBtn()->passed");
	}
	
	@Test(priority=16)
	public void verifyTitleOfUserPage()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"JavaByKiran | User");
		log.info("verifyTitleOfUserPage()->passed");
	}
	
	@Test(priority=17)
	public void clickLogout()
	{	
		aup.clickLogout();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"file:///C://Offline%20Website//Offline%20Website/pages/examples/logout.html");
		log.info("clickLogout()->passed");
	}
}
