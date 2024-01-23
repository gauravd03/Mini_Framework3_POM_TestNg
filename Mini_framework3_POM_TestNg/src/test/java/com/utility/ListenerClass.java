package com.utility;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testCase.Base;

public class ListenerClass implements ITestListener {
	
	//creating three object as following 
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	//TakeScreenshot screenshot;
	
	
	public void configureExtentReport() {
		//method for initializing class objects
		htmlReporter=new ExtentSparkReporter("reports/ExtentReports.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//adding system information/environment inforamtion (Note:if not mentioned no issue report will generated)
		reports.setSystemInfo("Machine ", "MyLaptop");
		reports.setSystemInfo("os", "Windows 11");
		
		//configuration to give look and feel to report (note :if not mentioned no issue report will generated)
		htmlReporter.config().setDocumentTitle("Extentlistener implementation demo in framework");
		htmlReporter.config().setReportName("This is report for Framework3");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	

	@Override
	public void onStart(ITestContext context) {
		System.out.println("started");
		
		configureExtentReport();  //calling extent report configuration method because at first of test execution extent report object should get created
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished");
		reports.flush();        //It is Important to flush object at end of test till report will not get saved



	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");

	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TestFailed "+ result.getName());
		
		//Below creating test for report and saving name and giving details
		test=reports.createTest("Test name: "+result.getName());  //here it getname will return method name of our test
		test.log(Status.FAIL,MarkupHelper.createLabel("Failed test case is:"+result.getName(), ExtentColor.RED) ); //here attaching  log to report

		
		//Taking screenshot of failed test
		 TakesScreenshot screenshot = (TakesScreenshot) Base.driver;
		 File src=screenshot.getScreenshotAs(OutputType.FILE);
		 File destination=new File("screenshots/Failed.png");
		 try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 test.addScreenCaptureFromPath("screenshots/Failed.png");
	}
@Override
public void onTestSuccess(ITestResult result) {
	test=reports.createTest("Test name: "+result.getName());
	test.log(Status.PASS,MarkupHelper.createLabel("Passes test case is:"+result.getName(), ExtentColor.GREEN) );
}
}
