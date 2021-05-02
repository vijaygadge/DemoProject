package com.TestClasses;

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
import jbk.pages.IndexPage;

public class TestDashboardPage extends TestBase
{
	WebDriver driver=null;
	IndexPage ip=null;
	DashboardPage dp=null;
	String parentId=null;
	
	@BeforeSuite
	public void setUp()
	{
		driver=initialization();
		log=Logger.getLogger(TestDashboardPage.class);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		ip=new IndexPage(driver);
		dp=ip.clickLoginButton();
		log.info("Dashboard page initialized");
		parentId=driver.getWindowHandle();
	}
	@AfterSuite()
	public void close()
	{
		driver.quit();
	}
	
	@Test(priority=0)
	public void verifyTitle()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"JavaByKiran | Dashboard");
		log.info("verifyTitle()->passed");
	}
	
	@Test(priority=1,dependsOnMethods="verifyTitle")
	public void verifyCurrentURL()
	{
		String h1 = driver.getCurrentUrl();
		String h="file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html";
		Assert.assertEquals(h1,h);
		log.info("verifyCurrentURL()->passed");
	}
	
	@Test(priority=2,dependsOnMethods="verifyCurrentURL")
	public void varifyH1Tag()
	{
		//driver.findElement(By.tagName("h1")).getText();
		String h1 = dp.headingText();
		String h="Dashboard Courses Offered";
		Assert.assertEquals(h1,h);
		log.info("varifyH1Tag()->passed");
	}
	
	@Test(priority=3)
	public void varifyLogoutText()
	{
		//driver.findElement(By.xpath("//a[text()='LOGOUT']")).getText();
		String logout = dp.logoutText1();
		String logout2="LOGOUT";
		Assert.assertEquals(logout,logout2);
		log.info("varifyLogoutText()->passed");
	}
	
	@Test(priority=4)
	public void varifyHome()
	{
		//driver.findElement(By.xpath("//ol[@class='breadcrumb']")).getText();
		String home = dp.olTagText();
		String home2="Home Dashboard";
		Assert.assertEquals(home,home2);
		log.info("varifyHome()->passed");
	}
	
	@Test(priority=5)
	public void varifyJBKTextInNavBar()
	{
		//driver.findElement(By.xpath("//b[text()='Java By Kiran']")).getText();
		String A = dp.jbkText();
		String B="Java By Kiran";
		Assert.assertEquals(A,B);
		log.info("varifyJBKTextInNavBar()->passed");
	}
	
	@Test(priority=6)
	public void varifyLeftBar()// The whole LHS Navigation Bar
	{
		//driver.findElement(By.xpath("//aside[@class='main-sidebar']")).getText();
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
		log.info("varifyLeftBar()->passed");
	}
	
	@Test(priority=7)
	public void varifyFooter()
	{
		//driver.findElement(By.xpath("//footer[@class='main-footer']")).getText();
		String t1= dp.verifyFooter();
		String t2="Design for Selenium Automation Test V 2.3.0\n" + 
				"Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		Assert.assertEquals(t1,t2);
		log.info("varifyFooter()->passed");
	}
	
	@Test(priority=8)
	public void varifySelenium()
	{
		//driver.findElement(By.xpath("//div[h3[contains(text(),'Selenium')]]")).getText();
		String f1= dp.verifyCourseSelenium();
		String f2="Selenium\n"+"Automation Testing";
		Assert.assertEquals(f1,f2);
		log.info("varifySelenium()->passed");
	}
	
	@Test(priority=9)
	public void varifyRHSContent()
	{
		//driver.findElement(By.xpath("//section[@class=\"content\"]")).getText();
		String f1= dp.verifyallCoursesText();
		String f2="Selenium\n" + 
				"Automation Testing\n" + 
				"More info\n" + 
				"Java / J2EE\n" + 
				"Software Development\n" + 
				"More info\n" + 
				"Python\n" + 
				"Data Science\n" + 
				"More info\n" + 
				"Php\n" + 
				"Web Development\n" + 
				"More info";
		Assert.assertEquals(f1,f2);
		log.info("varifyRHSContent()->passed");
	}
	
	@Test(priority=10)
	public void varifyMoreInfo()
	{
		String selenium1= dp.verifySeleMoreInfoText();
		String selenium2="More info";
		
		String softwareDev1= dp.verifyJavaMoreInfoText();
		String softwareDev2="More info";
		
		String python1= dp.verifyPythonMoreInfoText();
		String python2="More info";
		
		//		//h3[text()='Php']/../..//a//i
		//h3[text()='Php']/../../a ->also give single->/ to 'a' but it consider only first 'a' tag always
		String php1= dp.verifyphpMoreInfoText();
		String php2="More info";
	
		Assert.assertEquals(php1+python1+softwareDev1+selenium1,php2+python2+softwareDev2+selenium2);
		log.info("varifyMoreInfo()->passed");
	}

	@Test(priority=11,dependsOnMethods="verifyTitle")
	public void clickHome()
	{
		dp.clickHome();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html#");
		log.info("clickHome()->passed");
	}
	
	@Test(priority=12,dependsOnMethods="verifyTitle")
	public void clickJBKTextInNavBar()
	{
		//driver.findElement(By.xpath("//b[text()='Java By Kiran']")).click();
		dp.clickjbkText();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html");
		log.info("clickJBKTextInNavBar()->passed");
	}
	
	@Test(priority=13,dependsOnMethods="verifyTitle")
	public void clickOnlineText()// The whole LHS Navigation Bar
	{
		dp.clickOnlineText();
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,"file:///C://Offline%20Website//Offline%20Website/pages/examples/dashboard.html#");
		log.info("clickOnlineText()->passed");
	}
	
	@Test(priority=14)
	public void clickIMG() throws Exception
	{
		try {
			Actions act=new Actions(driver);
			WebElement logo=dp.getIMG();
			act.contextClick(logo).perform();
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		}catch(Exception e)
		{
			log.info(e.getMessage());
			log.info(e.getClass().getName());
			log.error("Unable to right click and press enter on \"Open image in new Tab\"");
		}
	}
	
	@Test(priority=15)
	public void mouseMove() throws Exception
	{
		try {
			WebElement logo=null;
			//WebDriverWait ww=new WebDriverWait(driver,30);;
			Actions act=new Actions(driver);
			 
			 logo=dp.getEle1();
			//ww.until(ExpectedConditions.visibilityOf(logo));
			act.moveToElement(logo).pause(2000).perform();
			System.out.println(logo.getAttribute("class")+" :1");
			
			 logo=dp.getEle2();
			//ww.until(ExpectedConditions.visibilityOf(logo));
			act.moveToElement(logo).pause(2000).perform();
			System.out.println(logo.getAttribute("class")+" :2");
			
			logo=dp.getEle3();
			//ww.until(ExpectedConditions.visibilityOf(logo));
			act.moveToElement(logo).pause(2000).perform();
			System.out.println(logo.getAttribute("class")+" :3");
			
			logo=dp.getEle4();
			//ww.until(ExpectedConditions.visibilityOf(logo));
			act.moveToElement(logo).pause(2000).perform();
			System.out.println(logo.getAttribute("class")+" :4");
		}catch(Exception e)
		{
			log.info(e.getMessage());
			log.info(e.getClass().getName());
			log.error("Unable to move mouse on WebElement");
		}
	}
	
	@Test(priority=16)
	public void verifyAllLinks_SwitchOnLinks() throws Exception
	{
		String link1="file:///C:/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf";
		String link2="file:///C:/Offline%20Website/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf";
		String link3="file:///C:/Offline%20Website/Offline%20Website/pages/pdf/python-syllabus.pdf";
		String link4="file:///C:/Offline%20Website/Offline%20Website/pages/examples/dashboard.html#";
		String link5="https://www.javabykiran.com/";
		String link6="file:///C:/Offline%20Website/Offline%20Website/dist/img/user2-160x160.jpg";
		System.out.println("Parent URL :"+driver.getCurrentUrl());
		
		dp.clickSeleMoreInfo();
		dp.clickJavaMoreInfo();
		dp.clickPythonMoreInfo();
		dp.clickphpMoreInfo();
		dp.clickFooter();//click footer Link->JavaByKiran
		try {
			Set<String> s=driver.getWindowHandles();
			for(String str: s)
			{
				if(!str.equals(parentId))
				{
					driver.switchTo().window(str);
					String url2=driver.getCurrentUrl();
					System.out.println(url2);
					if(url2.equals(link1))
					{
						Assert.assertEquals(url2, link1);
					}
					else if(url2.equals(link2))
					{
						Assert.assertEquals(url2, link2);
					}
					else if(url2.equals(link3))
					{
						Assert.assertEquals(url2, link3);
					}
					else if(url2.equals(link4))
					{
						Assert.assertEquals(url2, link4);
					}
					else if(url2.equals(link5))
					{
						Assert.assertEquals(url2, link5);
					}
					else if(url2.equals(link6))
					{
						Assert.assertEquals(url2, link6);
					}
					Thread.sleep(1000);
					driver.close();
				}driver.switchTo().window(parentId);
			}
		}catch(Exception e)
		{
			log.info(e.getMessage());
			log.info(e.getClass().getName());
			log.error("Unable to move mouse on WebElement");
		}
	}
	
	@Test(priority=17,dependsOnMethods="verifyTitle")
	public void clickLogoutButton()
	{
		dp.clickLogoutButton();
		log.info("clickLogoutButton()->passed");
	}
	
	@Test(priority=18,dependsOnMethods="clickLogoutButton")
	public void verifyLogoutText()
	{	
		String logoutText=dp.logoutText2();
		Assert.assertEquals(logoutText,"Logout successfully");
		log.info("verifyLogoutText()->passed");
	}
}
