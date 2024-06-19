package com.tutorialsNinja.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PracticeClass {

	
	public static void main(String[]args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement dropdown= driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select s = new Select(dropdown);
		//s.selectByIndex(1);
		s.selectByValue("option2");
		Thread.sleep(3000);
		
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 900)");
        
        Thread.sleep(3000);
        WebElement mousehover = driver.findElement(By.xpath("//button[text()='Mouse Hover']"));
        Actions ac = new Actions(driver);
		
		ac.moveToElement(mousehover).build().perform();
		
		
		
	}

}
