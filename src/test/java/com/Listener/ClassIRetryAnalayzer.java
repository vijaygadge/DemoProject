package com.Listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.TestBase.TestBase;

public class ClassIRetryAnalayzer extends TestBase implements IRetryAnalyzer
{
	public ClassIRetryAnalayzer()
	{
		log=Logger.getLogger(ClassIRetryAnalayzer.class);
	}
	int count =1;
	int max=3;

	@Override
	public boolean retry(ITestResult result) 
	{
		log.info("This @Test is Retryed !! "+result);
		if(count<=max) {
			count++;
			return true;
		}
		return false;
	}

}
