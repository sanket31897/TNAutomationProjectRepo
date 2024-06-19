package com.turorialsNinja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
WebDriver driver ;
	
	//Objects
	@FindBy(css="#input-firstname")
	private WebElement firstnamef;
	
	@FindBy(css="#input-lastname")
	private WebElement lastNamef;
	
	@FindBy(css="#input-email")
	private WebElement emailf;
	
	@FindBy(css="#input-telephone")
	private WebElement telephonef;
	
	@FindBy(css="#input-password")
	private WebElement pwdf;
	
	@FindBy(css="#input-confirm")
	private WebElement confirmpwdf;
	
	@FindBy(name="agree")
	private WebElement agreebtn;
	
	@FindBy(css="input.btn.btn-primary")
	private WebElement continuebtn;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterbtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement inputEmailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwdWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterFirstName(String firstNameText) {
		firstnamef.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNamef.sendKeys(lastNameText);
	}
	
	public void enterEmailTxt(String emailText) {
		emailf.sendKeys(emailText);
	}
	
	public void enterTelephoneTxt(String telephoneText) {
		telephonef.sendKeys(telephoneText);
	}
	
	public void enterPasswordTxt(String pwdText) {
		pwdf.sendKeys(pwdText);
	}
	
	public void enterPasswordConfmTxt(String pwdConfmText) {
		confirmpwdf.sendKeys(pwdConfmText);
	}
	
	public void clickOnAgreebtn() {
		agreebtn.click();
	}
	
	public void clickOnContinuebtn() {
		continuebtn.click();
	}
	
	public void clickOnNewsLetterbtn() {
		newsLetterbtn.click();
	}
	
	public String retriveDuplicateEmailAdWarningTxt() {
		String dEmailWarningtxt =duplicateEmailAddWarning.getText();
		return dEmailWarningtxt;
	}
	
	public String retrivePrivacyPloicyWarningTxt() {
		String privacyPoliWarningtxt =privacyPolicyWarning.getText();
		return privacyPoliWarningtxt;
	}
	
	public String retriveFirstNameWarningTxt() {
		String firstNameWarningtxt =firstNameWarning.getText();
		return firstNameWarningtxt;
	}
	
	public String retriveLastNameWarningTxt() {
		String lastNameWarningtxt =lastNameWarning.getText();
		return lastNameWarningtxt;
	}
	
	public String retriveinputEmailWarningTxt() {
		String inputEmailWarningtxt =inputEmailWarning.getText();
		return inputEmailWarningtxt;
	}
	
	public String retriveTelephoneWarningTxt() {
		String telephoneWarningtxt =telephoneWarning.getText();
		return telephoneWarningtxt;
	}
	
	public String retrivePasswordWarningTxt() {
		String pwdWarningtxt =passwdWarning.getText();
		return pwdWarningtxt;
	}
	
	
	
	
	
	
	
}
