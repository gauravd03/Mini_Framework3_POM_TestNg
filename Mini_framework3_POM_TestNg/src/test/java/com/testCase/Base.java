package com.testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utility.configure;

public class Base {
	
	configure config=new configure();
	public static WebDriver driver;
	String browser=config.getBrowser();
	
	
	
	Base(){
		
	}
	
	@BeforeClass
	public void setup() {
		switch(browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default: 
			driver=null;
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(config.getUrl());
		
	}
	
  @AfterClass
  public void tearDown() {
	  driver.close();
  }

}
