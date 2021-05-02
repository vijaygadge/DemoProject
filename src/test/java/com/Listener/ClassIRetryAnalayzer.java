package com.Listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.TestBase.TestBase;

public class ClassIRetryAnalayzer extends TestBase implements IRetryAnalyzer
{
		private Logger log=Logger.getLogger(ClassIRetryAnalayzer.class);
	int count =1;
	int max=3;

	@Override
	public boolean retry(ITestResult result) 
	{
		log.info(count+" time @Test case is Retryed !! "+result);
		if(count<=max) {
			count++;
			return true;
		}
		return false;
	}

}
