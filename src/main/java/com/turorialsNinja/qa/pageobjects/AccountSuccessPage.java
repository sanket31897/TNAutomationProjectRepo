package com.turorialsNinja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
WebDriver driver ;
	
	//Objects
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accSuccessPageheading;
	
	
	
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String retriveAccSuccessHeadingText() {
		String aspageHeading = accSuccessPageheading.getText();
		return aspageHeading;
	}
	
	
}
