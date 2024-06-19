package com.tutorialsNinja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.turorialsNinja.qa.pageobjects.AccountSuccessPage;
import com.turorialsNinja.qa.pageobjects.HomePage;
import com.turorialsNinja.qa.pageobjects.RegisterPage;
import com.tutorialsNinja.qa.base.BaseClass;
import com.tutorialsNinja.qa.utils.Utitlities;

public class RegisterTest extends BaseClass {
	
public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeBrowser(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccDropMenu();
		hp.selectRegister();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	@Test (priority=1)
	public void verifyRegisterAnAccountWithMandFields() {
		RegisterPage rp = new RegisterPage(driver);
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmailTxt(Utitlities.generateRandomEmail());
		rp.enterTelephoneTxt(dataProp.getProperty("telephoneNumber"));
		rp.enterPasswordTxt(prop.getProperty("validPassword"));
		rp.enterPasswordConfmTxt(prop.getProperty("validPassword"));
		rp.clickOnAgreebtn();
		rp.clickOnContinuebtn();
		AccountSuccessPage asPage = new AccountSuccessPage(driver);
		String actSuccessHeading = asPage.retriveAccSuccessHeadingText();
		
		Assert.assertEquals(actSuccessHeading, dataProp.getProperty("accSuccessfullycreatedHeading"), "Account success message is not displayed");
		
	}

	@Test (priority=2)
	public void verifyRegisterAnAccountWithAllFields() throws InterruptedException {
		RegisterPage rp = new RegisterPage(driver);
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmailTxt(Utitlities.generateRandomEmail());
		rp.enterTelephoneTxt(dataProp.getProperty("telephoneNumber"));
		rp.enterPasswordTxt(prop.getProperty("validPassword"));
		rp.enterPasswordConfmTxt(prop.getProperty("validPassword"));
		rp.clickOnNewsLetterbtn();
		rp.clickOnAgreebtn();
		rp.clickOnContinuebtn();
		AccountSuccessPage asPage = new AccountSuccessPage(driver);
		String actSuccessHeading = asPage.retriveAccSuccessHeadingText();
		
		Assert.assertEquals(actSuccessHeading, dataProp.getProperty("accSuccessfullycreatedHeading"), "Account success message is not displayed");
		
		
		
	}

	@Test (priority=3)
	
	public void verifyRegisterAnAccountWithExistingEmailAddress() {
		RegisterPage rp = new RegisterPage(driver);
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmailTxt(prop.getProperty("validEmail"));
		rp.enterTelephoneTxt(dataProp.getProperty("telephoneNumber"));
		rp.enterPasswordTxt(prop.getProperty("validPassword"));
		rp.enterPasswordConfmTxt(prop.getProperty("validPassword"));
		rp.clickOnNewsLetterbtn();
		rp.clickOnAgreebtn();
		rp.clickOnContinuebtn();	

		String actWarning= rp.retriveDuplicateEmailAdWarningTxt();
		Assert.assertTrue(actWarning.contains(dataProp.getProperty("duplicateEmailWarning")), "Email Address already registred message is not displayed");
		
	}


	@Test (priority=4)
	public void verifyRegisterAnAccountWithotFillingAnyDetails() {
		RegisterPage rp = new RegisterPage(driver);
		rp.clickOnContinuebtn();
		

		String actualPrivacyPolicyWarning= rp.retrivePrivacyPloicyWarningTxt();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not displayed");

		String actualFirstNameWarning= rp.retriveFirstNameWarningTxt();
		Assert.assertEquals(actualFirstNameWarning,dataProp.getProperty("firstNameWarning"), "First Name warning Message is not displayed.");

		String actualLastNameWarning= rp.retriveLastNameWarningTxt();
		Assert.assertEquals(actualLastNameWarning,dataProp.getProperty("lastNameWarning"), "Last Name warning Message is not displayed.");
		
		String actualEmailWarning= rp.retriveinputEmailWarningTxt();
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailAddressWarning"), "Email warning Message is not displayed.");
        
		String actualTelephoneWarning= rp.retriveTelephoneWarningTxt();
		Assert.assertEquals(actualTelephoneWarning,dataProp.getProperty("telephoneWarning"), "Telephone warning Message is not displayed.");
		
		String actualPasswordWarning= rp.retrivePasswordWarningTxt();
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"), "Password warning Message is not displayed.");



		
	}





}
