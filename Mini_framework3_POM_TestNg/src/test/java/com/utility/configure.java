package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class configure {
	
	Properties prop;
	String filePath="src\\test\\resource\\testData.properties";
	
	public configure(){
		try {
		prop=new Properties();
		
			FileInputStream fis=new FileInputStream(filePath);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	
	public String getEmail() {
		return prop.getProperty("Email");
	}
	
	public String getPass() {
		return prop.getProperty("pass");
	}
	
	

}
