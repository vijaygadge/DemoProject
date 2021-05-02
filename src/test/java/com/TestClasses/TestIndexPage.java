package com.TestClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import jbk.pages.DashboardPage;
import jbk.pages.IndexPage;
import jbk.pages.RegisterPage;

public class TestIndexPage extends TestBase
{
	WebDriver driver=null;
	IndexPage ip=null;
	DashboardPage dp=null;
	RegisterPage rp=null;
	
	@BeforeSuite
	public void setUp()
	{
		driver=initialization();
		log=Logger.getLogger(TestIndexPage.class);
		ip=new IndexPage(driver);
	}
	@AfterSuite
	public void close()
	{
		driver.close();
	}
	
	@Test(priority=0)
	public void verifyCurrentURL()
	{
		String actualText=driver.getCurrentUrl();
		String expectedText="file:///C://Offline%20Website//Offline%20Website/index.html";
		Assert.assertEquals(actualText, expectedText);
		log.info("verifyCurrentURL()->passed");
	}
	
	@Test(priority=1)
	public void logoText()
	{
		String actualText=ip.boldText();
		String expectedText="Java By Kiran";
		Assert.assertEquals(actualText, expectedText);
		log.info("logoText()->passed");
	}
	
	@Test(priority=2)
	public void clickOnLogo() throws InterruptedException
	{
		ip.clickBoldText();
		log.info("clickOnLogo()->passed");
	}
	
	@Test(priority=3)
	public void clickOnCoursesText() throws InterruptedException
	{
		ip.clickCoursesText();
		log.info("clickOnCoursesText()->passed");
	}
	
	@Test(priority=4)
	public void coursesText()
	{
		String actualText2=ip.coursesText();
		String expectedText2="JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actualText2, expectedText2);
		log.info("coursesText()->passed");
	}
	
	@Test(priority=5)
	public void headingText()
	{
		String actualText3=ip.headingText();
		String expectedText3="Sign in to start your session";
		Assert.assertEquals(actualText3, expectedText3);
		log.info("headingText()->passed");
	}
	
	@Test(priority=6)
	public void registerText()
	{
		String actualText4=ip.registerText();
		String expectedText4="Register a new membership";
		Assert.assertEquals(actualText4, expectedText4);
		log.info("registerText()->passed");
	}
	
	@Test(priority=7,dataProvider="loginData")
	public void TestLoginCredentials(String uname,String pass) throws InterruptedException
	{
		//lp.clickToRegister();
		ip.enterUserName(uname);
		ip.enterPassword(pass);
		dp=ip.clickLoginButton();
		
	//if the DashBoard page will came than Click 'Logout' togo---> Login Pages
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
			dp.clickLogoutButton();
		
		log.info("TestLoginCredentials()->passed");
	}
	@DataProvider
	  public String[][] loginData() throws Exception
	 {
		return new String[][] 
		{
			new String[] {"mangesh@gmail.com","qwerty"},
			new String[] {"kiran@gmail.com","123456"},//Correct Login Creadencials
			new String[] {"neelam@gmail.com","m123456"},
			new String[] {"example@gmail.com","01010101"},
			
		};		
	  }
	
	@Test(priority=8)
	public void directSignIn()
	{
		ip.clickLoginButton();
		log.info("directSignIn()->passed");
	}
	
	@Test(priority=9,dependsOnMethods="directSignIn",groups="ErrorText")
	public void verifyEmailErrorText()
	{
		//ip.clickLoginButton();//To Don`t Use dependsOnMethods
		String actualText=ip.emailErrorText();
		String expectedText="Please enter email as kiran@gmail.com";
		Assert.assertEquals(actualText,expectedText);
		log.info("verifyEmailErrorText()->passed");
	}
	
	@Test(priority=10,dependsOnMethods="directSignIn",groups="ErrorText")
	public void verifyPasswordErrorText()
	{
		//ip.clickLoginButton();//To Don`t Use dependsOnMethods
		String actualText=ip.passwordErrorText();
		String expectedText="Please enter password 123456";
		Assert.assertEquals(actualText,expectedText);
		log.info("verifyPasswordErrorText()->passed");
	}
	
	@Test(priority=11)
	public void clickIMG() throws Exception
	{
		String parentId=driver.getWindowHandle();
		System.out.println("Parent Window"+driver.getCurrentUrl());
		try {
			Actions act=new Actions(driver);
			WebElement logo=ip.getLogo();
			act.contextClick(logo).perform();
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
			Set<String> set=driver.getWindowHandles();
			for(String str:set)
			{
				if(!str.equals(parentId))
				{
					driver.switchTo().window(str);
					Thread.sleep(1000);
					System.out.println("Child Window"+driver.getCurrentUrl());
					driver.close();
				}driver.switchTo().window(parentId);
			}log.info("clickIMG()->passed");
		}catch(Exception e)
		{
			log.info(e.getMessage());
			log.info(e.getClass().getName());
			log.error("Unable to switch on child window");
		}
	}
}