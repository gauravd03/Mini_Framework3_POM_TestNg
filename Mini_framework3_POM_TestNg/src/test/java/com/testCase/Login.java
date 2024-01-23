package com.testCase;

import org.testng.annotations.Test;

import com.pageobjects.HomePgObjects;
import com.pageobjects.LoginPageObjects;

import junit.framework.Assert;

public class Login extends Base {
	
	
	
	@Test
	public void clickOnLogin() {
		HomePgObjects HpPg=new HomePgObjects(super.driver);
		
		HpPg.clickOnLoginBtn();
		
		LoginPageObjects loginObj=new LoginPageObjects(super.driver);
		loginObj.enterEmail(config.getEmail());
		loginObj.enterPassword(config.getPass());
		loginObj.clickOnLogin();
		Assert.assertTrue(true);
		
		
		
	}
	
	@Test
	public void FailTest() {
		//Assert.assertTrue(false); //fail test for extent report 
	}

}
