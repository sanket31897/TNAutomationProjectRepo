package com.tutorialsNinja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.turorialsNinja.qa.pageobjects.AccountPage;
import com.turorialsNinja.qa.pageobjects.HomePage;
import com.turorialsNinja.qa.pageobjects.LoginPage;
import com.tutorialsNinja.qa.base.BaseClass;
import com.tutorialsNinja.qa.utils.Utitlities;

public class LoginTest extends BaseClass {
	
	public WebDriver driver;
	
//	public Login() {
//		super();
//	}
//	
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowser(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccDropMenu();
		hp.selectLogin();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
     @Test (priority = 1, dataProvider = "supplyTestData")
	public void verifyLoginWithValidCred(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.enteremailAddress(email);
		lp.enterPassword(password);
	   lp.clickOnLoginbtn();
	   AccountPage ap= new AccountPage(driver);
	    Assert.assertTrue(ap.getDisplayStatusOfEditYourAccInfo(), "Edit your account information option is not displayed.");
         
     }
     
     @DataProvider
     public Object [][] supplyTestData() {
    
    	 Object [][] data = Utitlities.getTestDataFromExcel("Login");
    			 return data;
     
     }
     
     
     
     @Test(priority = 2)
     public void verifyLoginWithInvalidCred() {
    	 LoginPage lp = new LoginPage(driver);
 		lp.enteremailAddress(Utitlities.generateRandomEmail());
 	    lp.enterPassword(dataProp.getProperty("invalidPassword"));
 	    lp.clickOnLoginbtn();
 	    
 	   String actMessage = lp.retriveWarningMessagetext();
 	   String expectedMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
 	   Assert.assertTrue(actMessage.contains(expectedMessage),"Warning: No match for E-Mail Address and/or Password. Message is not displayed");
 	   
 	   
          
      }
     
     @Test(priority = 3)
     public void verifyLoginWithInvalidEmailValidPass() {
    	 LoginPage lp = new LoginPage(driver);
  		lp.enteremailAddress(Utitlities.generateRandomEmail());
  	    lp.enterPassword(prop.getProperty("validPassword"));
  	    lp.clickOnLoginbtn();
 	    
 	    
 	   String actMessage =  lp.retriveWarningMessagetext();
 	   String expectedMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
 	   Assert.assertTrue(actMessage.contains(expectedMessage),"Warning: No match for E-Mail Address and/or Password. Message is not displayed");
 	   
 	   
          
      }
     
     @Test(priority = 4)
     public void verifyLoginWithValidEmailInvalidPass() {
    	 LoginPage lp = new LoginPage(driver);
   		lp.enteremailAddress(prop.getProperty("validEmail"));
   	    lp.enterPassword(dataProp.getProperty("invalidPassword"));
   	    lp.clickOnLoginbtn();
 	    
 	    
 	   String actMessage = lp.retriveWarningMessagetext();
 	   String expectedMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
 	   Assert.assertTrue(actMessage.contains(expectedMessage),"Warning: No match for E-Mail Address and/or Password. Message is not displayed");
 	   
 	   
          
      }
     
     @Test(priority = 5)
     public void verifyLoginWithoutCred() {
    	 
    	 LoginPage lp = new LoginPage(driver);
    	    lp.clickOnLoginbtn();
 	    
 	   String actMessage = lp.retriveWarningMessagetext();
 	   String expectedMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
 	   Assert.assertTrue(actMessage.contains(expectedMessage),"Warning: No match for E-Mail Address and/or Password. Message is not displayed");
 	   
 	   
          
      }
     
     
  
     
     
}
