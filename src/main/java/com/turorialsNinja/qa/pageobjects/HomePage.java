package com.turorialsNinja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver ;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(css="input.form-control.input-lg")
	private WebElement searchboxField;
	
	@FindBy(css="button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnMyAccDropMenu() {
		myAccDropMenu.click();
	}
	
	public void selectLogin() {
		loginoption.click();
	}
	
	public void selectRegister() {
		registerOption.click();
	}
	
	public void enterTextInSearchBox(String searchBoxTxt) {
		searchboxField.sendKeys(searchBoxTxt);
	}
	
	public void clickOnSearchBtn() {
		searchButton.click();
	}
}
