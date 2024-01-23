package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	public LoginPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//input[@name=\"email\"]")
	public WebElement emailInput;
	
	
	@FindBy (xpath="//input[@name=\"password\"]")
	public WebElement passInput;
	
	@FindBy (xpath="//div[text()='Login']")
	public WebElement loginBtn;
	
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		passInput.sendKeys(pass);
		
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}
	

}
