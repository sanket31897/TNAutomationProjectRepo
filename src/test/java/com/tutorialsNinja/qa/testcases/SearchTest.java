package com.tutorialsNinja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.turorialsNinja.qa.pageobjects.HomePage;
import com.turorialsNinja.qa.pageobjects.SearchPage;
import com.tutorialsNinja.qa.base.BaseClass;

public class SearchTest extends BaseClass{
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver= initializeBrowser(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		HomePage hp = new HomePage(driver);
		hp.enterTextInSearchBox(dataProp.getProperty("validProduct"));
		hp.clickOnSearchBtn();
		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.displayStatusHPProductText());
	
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		HomePage hp = new HomePage(driver);
		hp.enterTextInSearchBox(dataProp.getProperty("invalidProduct"));
		hp.clickOnSearchBtn();
		SearchPage sp = new SearchPage(driver);
		String actualSearchMessage = sp.searchMessageText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductInSearchResults"),"Search Error Message is not displayed.");
		}
	
	
	@Test(priority=3)
	public void verifySearchWithoutAnyProduct() {
		HomePage hp = new HomePage(driver);
		hp.clickOnSearchBtn();
		SearchPage sp = new SearchPage(driver);
		String actualSearchMessage = sp.searchMessageText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductInSearchResults"),"Search Error Message is not displayed.");
		}

}
