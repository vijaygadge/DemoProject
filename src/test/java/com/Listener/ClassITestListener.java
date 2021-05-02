package com.Listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.TestBase.TestBase;

public class ClassITestListener extends TestBase implements ITestListener
{
	public ClassITestListener()
	{
		log=Logger.getLogger(ClassITestListener.class);
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		log.info("Test Case Started :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		log.info("Test Case Success :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test Case Failed :"+result.getName());
		
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyyhhmmss");
		TakesScreenshot ts=(TakesScreenshot)TestBase.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/ScreenShots/Demo"+sdf.format(new Date())+".png";//+".jpg";//+".jpeg";
		
		try {
			log.info("Saving a ScreenShot for Failed TestCase");
			FileUtils.copyFile(src,new File(path));}
		catch(Exception e)
		{
			log.error("ScreenShot is not Saved");
			log.error(e.getClass().getName());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Skipped :"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Suit Started !!!!");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("Suit Finished !!!!");
	}
	
}
