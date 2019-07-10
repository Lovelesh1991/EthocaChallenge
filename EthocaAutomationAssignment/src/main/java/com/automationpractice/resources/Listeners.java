package com.automationpractice.resources;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		getScreenshots(result);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
	
		// TODO Auto-generated method stub
		
	}

	
	/***
	 ** This method captures the screenshot on test failure and saves it in given
	 * location
	 * 
	 * @param result
	 * @throws IOException
	 */
	public void getScreenshots(ITestResult result) {
		String TestStep = result.getName();
		String Location = prop.getProperty("Path");
		
		
		
		//String Location = prop.getProperty("Path");
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(Location + TestStep + ".png"));
			Log.info("****************************Screenshot Saved at " + Location + "***********");
		} catch (Exception e) {
			Log.info("#############Exception Occured while taking screenshot##################" + e.getMessage());
		}
	}
	}



