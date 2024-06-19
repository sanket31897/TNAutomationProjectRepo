package com.turorialsNinja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver ;
	
	//Objects
	@FindBy(css="#input-email")
	private WebElement emailfieild;
	
	@FindBy(id="input-password")
	private WebElement pwdfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(css="div.alert.alert-danger.alert-dismissible")
	private WebElement emailPasswordNotMatching;
	
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enteremailAddress(String emailText) {
		emailfieild.sendKeys(emailText);
	}
	
	public void enterPassword(String pwdText) {
		pwdfield.sendKeys(pwdText);
	}
	
	public void clickOnLoginbtn() {
		loginBtn.click();
	}
	
	public String retriveWarningMessagetext() {
		String RetriveWarningtxt = emailPasswordNotMatching.getText();
		return RetriveWarningtxt;
	}
	
}
