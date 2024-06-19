package com.tutorialsNinja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsNinja.qa.utils.Utitlities;

public class BaseClass {
    
    WebDriver driver;
    
public Properties prop;
   public Properties dataProp ;  
    
   public BaseClass() {
	   
	   prop = new Properties();
	   File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\config\\config.properties");
	 
	   dataProp = new Properties();
	   File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\testdata\\testdata.properties");
	   
	   FileInputStream fis2;
	   
	   try {
	   fis2 = new FileInputStream(dataPropFile);
	   dataProp.load(fis2);
	   } catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
	   FileInputStream fis;
	try {
		fis = new FileInputStream(propFile);
		prop.load(fis);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   
   
   
    public WebDriver initializeBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser name is not valid");
        }
             
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utitlities.WAIT_TIME));
        driver.get(prop.getProperty("url"));
        
        
        return driver;
    }
}
