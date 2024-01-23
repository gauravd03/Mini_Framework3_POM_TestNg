package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePgObjects {
	
	WebDriver driver;
	public HomePgObjects(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	


	@FindBy (xpath="//a[@class=\"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")
	public WebElement LoginBtn;
	
	

	public void clickOnLoginBtn() {
		LoginBtn.click();
	}

}
