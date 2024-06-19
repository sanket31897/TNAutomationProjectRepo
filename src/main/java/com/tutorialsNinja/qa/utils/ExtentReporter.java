package com.tutorialsNinja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		ExtentReports extreport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("TutorialsNinja Automation Test Results");
		spark.config().setDocumentTitle("TN Automation Report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extreport.attachReporter(spark);
		
		Properties prop = new Properties();
		File configPropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\config\\config.properties");
	     try {
		FileInputStream fis = new FileInputStream(configPropfile);
		prop.load(fis);
	     }
		catch(Throwable e){
			e.printStackTrace();
		}
		extreport.setSystemInfo("Application URL", prop.getProperty("url"));
		extreport.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extreport.setSystemInfo("Email", prop.getProperty("validEmail"));
		extreport.setSystemInfo("Password", prop.getProperty("validPassword"));
		extreport.setSystemInfo("OS", System.getProperty("os.name"));
		extreport.setSystemInfo("User Name", System.getProperty("user.name"));
	    extreport.setSystemInfo("Java Version", System.getProperty("java.version"));
	
	    return extreport;
	}

	
}
