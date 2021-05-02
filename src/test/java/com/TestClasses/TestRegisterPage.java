package com.TestClasses;

import java.io.FileInputStream;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;

import com.TestBase.TestBase;
import jbk.pages.IndexPage;
import jbk.pages.RegisterPage;

public class TestRegisterPage extends TestBase
{
	WebDriver driver;
	RegisterPage rp=null;
	IndexPage ip=null;
	
	@BeforeSuite
	public void setUp()
	{
		driver=initialization();
		log=Logger.getLogger(TestRegisterPage.class);
		ip=new IndexPage(driver);
		rp=ip.clickToRegister();
		log.info("RegisterPage Initialized");
	}
	@AfterSuite()
	public void close()
	{
		driver.close();
	}
	
	@Test(priority=1)//,dependsOnMethods="clickNewRegister")
	public void verifyCurrentURL()
	{
		String actualText=driver.getCurrentUrl();
		String expectedText="file:///C://Offline%20Website//Offline%20Website/pages/examples/register.html";
		Assert.assertEquals(actualText, expectedText);
		log.info("verifyCurrentURL() ->passed");
	}
	
	@Test(priority=2)
	public void boldText()
	{
		String actualText=rp.boldText();
		String expectedText="Java By Kiran";
		Assert.assertEquals(actualText,expectedText);
		log.info("boldText() ->passed");
	}
	
	@Test(priority=3)
	public void headingText()
	{
		String actualText=rp.headingText();
		String expectedText="Register a new membership";
		Assert.assertEquals(actualText,expectedText);
		log.info("headingText() ->passed");
	}
	
	@Test(priority=4,dataProvider="registerDetails")
	public void fillDetails(String UserName,String Mobile,String Email,String Password) throws InterruptedException
	{
		rp.enterName(UserName);
		rp.enterMobileNo(Mobile);
		rp.enterEmail(Email);
		rp.enterPassword(Password);
		rp.clickToSignIn();
		Alert al= driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
		log.info("fillDetails() ->passed");
	}
	@DataProvider
	public Object[][] registerDetails() throws Exception
	{
		FileInputStream fis=new FileInputStream("src\\test\\resources/TestData.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet("RegisterPageData");
		
		String dataArr[][]=new String[sh.getRows()-1][sh.getColumns()];//[]
		System.out.println("No. of columns :"+sh.getColumns());
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
	
	@Test(priority=5)//,dependsOnMethods="clickNewRegister")
	public void alreadyRegText()
	{
		String actualText=rp.alreadyRegText();
		String expectedText="I already have a membership";
		Assert.assertEquals(actualText,expectedText);
		log.info("alreadyRegText() ->passed");
	}
	
	@Test(priority=6)//,dependsOnMethods="clickNewRegister")
	public void signInToReg() throws InterruptedException
	{
		rp.clearFields();
		rp.clickToSignIn();
		log.info("signInToReg() ->passed");
	}
	
	@Test(priority=7,dependsOnMethods="signInToReg",groups="ErrorText")
	public void verifyNameError()
	{
		//rp.clickToSignIn();//To Don`t Use dependsOnMethods
		String actualText=rp.nameError();
		String expectedText="Please enter Name.";
		Assert.assertEquals(actualText,expectedText);
		log.info("verifyNameError() ->passed");
	}
	
	@Test(priority=8,dependsOnMethods="signInToReg",groups="ErrorText")
	public void verifyMobileNoError()
	{
		//rp.clickToSignIn();//To Don`t Use dependsOnMethods
		String actualText=rp.mobileNoError();
		String expectedText="Please enter Mobile.";
		Assert.assertEquals(actualText,expectedText);
		log.info("verifyMobileNoError() ->passed");
	}
	
	@Test(priority=9,dependsOnMethods="signInToReg",groups="ErrorText")
	public void verifyEmailError()
	{
		//rp.clickToSignIn();//To Don`t Use dependsOnMethods
		String actualText=rp.emailError();
		String expectedText="Please enter Email.";
		Assert.assertEquals(actualText,expectedText);
		log.info("verifyEmailError() ->passed");
	}
	
	@Test(priority=10,dependsOnMethods="signInToReg",groups="ErrorText")
	public void verifyPasswordError()
	{
		//rp.clickToSignIn();//To Don`t Use dependsOnMethods
		String actualText=rp.passwordError();
		String expectedText="Please enter Password.";
		Assert.assertEquals(actualText,expectedText);
		log.info("verifyPasswordError() ->passed");
	}
	
	@Test(priority=11)//,dependsOnMethods="clickNewRegister")
	public void clickOnAlreadyRegText()
	{
		rp.clickAlreadyReg();
		log.info("clickOnAlreadyRegText() ->passed");
	}
	
	@Test(priority=12,dependsOnMethods="clickOnAlreadyRegText")
	public void verifyCurrentURL2()
	{
		String actualText=driver.getCurrentUrl();
		String expectedText="file:///C://Offline%20Website//Offline%20Website/index.html";
		Assert.assertEquals(actualText, expectedText);
		log.info("verifyCurrentURL2() ->passed");
	}
}
