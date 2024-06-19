package com.tutorialsNinja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinja.qa.utils.ExtentReporter;

public class MyListeners implements ITestListener {
	
	
	ExtentReports extentReport;
	ExtentTest extentText;
	
	
	@Override
	public void onStart(ITestContext context) {
		
		extentReport = ExtentReporter.generateExtentReport();
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName= result.getName();
		extentText = extentReport.createTest(testName);
		extentText.log(Status.INFO,testName+"started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName= result.getName();
		extentText.log(Status.PASS,testName+"Got successfully executed.");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destScreenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentText.addScreenCaptureFromPath(destScreenshotPath);
		extentText.log(Status.INFO, result.getThrowable());
		extentText.log(Status.FAIL, testName+ "Got Failed.");
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName= result.getName();
		extentText.log(Status.INFO, result.getThrowable());
		extentText.log(Status.SKIP, testName+ "Got Skipped.");
	
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathExtentReport= System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentrep = new File(pathExtentReport);
		try {
			Desktop.getDesktop().browse(extentrep.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	

}
