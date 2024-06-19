package com.turorialsNinja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
WebDriver driver ;
	
	//Objects
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement searchMessagetxt;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public Boolean displayStatusHPProductText() {
		Boolean HPProducttxt= validHPProduct.isDisplayed();
		return HPProducttxt;
	}
	
	public String searchMessageText() {
		String StringMessagetxt= searchMessagetxt.getText();
		return StringMessagetxt;
	}
}
