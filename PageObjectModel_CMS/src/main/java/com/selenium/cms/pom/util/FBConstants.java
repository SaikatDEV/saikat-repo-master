package com.selenium.cms.pom.util;


public class FBConstants{
	
	public static final String BTYPE = "Chrome";
	
//	Paths
//	In Windows, it can be like this: F:\\chromedriver\\chromedriver.exe
	public static final String CHROME_DRIVER_EXE = System.getProperty("user.dir") + "/chromedriver/chromedriver.exe";
	public static final String REPORT_PATH = System.getProperty("user.dir") + "/reports/";
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/screenshots/";
	public static final String REPORTS_CONFIG_PATH = System.getProperty("user.dir") + "/ReportsConfig.xml";
	
  
//	Urls
	public static final String HOMEPAGE_URL = "https://facebook.com";
	
//	TestData
	public static final String USER_NAME = "asmenterprise.llc@gmail.com";
	public static final String PASSWORD = "Ctg310306";

	
//	locators - We can keep these inside the page classes
	public static final String LOGIN_USERNAME = "#email";
	public static final String LOGIN_PASSWORD = "#pass";
	public static final String LOGIN_BUTTON = "input[value='Log In']";
  
}