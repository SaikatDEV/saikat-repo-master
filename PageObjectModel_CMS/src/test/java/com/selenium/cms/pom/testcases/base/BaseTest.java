package com.selenium.cms.pom.testcases.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.cms.pom.util.ExtentManager;
import com.selenium.cms.pom.util.FBConstants;
import com.selenium.cms.pom.util.TestUtil;

public class BaseTest{
	
	
	public static WebDriver driver = null;
	
//	For Reports initialize ExtentReport here. So it will be available in all tests
	public ExtentReports extent = ExtentManager.getInstance();
	
//	Declare ExtentTest but don't initialize
	public ExtentTest test;
  
	public void initEnv(String bType){
		
		if (driver == null){
			if (bType.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", FBConstants.CHROME_DRIVER_EXE);
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", Integer.valueOf(2));
				ChromeOptions option = new ChromeOptions();
				option.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(option);
				
			} else if (bType.equalsIgnoreCase("Mozzila")){
				driver = new FirefoxDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
	
	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
	}
	
	public void reportFailure(String failureMessage){		
		takeScreenshot();
		test.log(LogStatus.FAIL, failureMessage);
		Assert.fail(failureMessage);
	}
	
	public boolean isElementPresent(WebElement we) {
	    try {
	        we.isDisplayed();
	        return true;
	    } catch(NoSuchElementException e) {
	    	
//	    	We can not use this below as we did not initialize the Extent Report in the Base Page
//	        test.log(LogStatus.INFO, "Element does not exist.");
	    	reportFailure("Element does not exist. WebElement: " + we);
	        return false;
	    }
	}
	
	public void clickButton(WebElement we) {
		try{
			we.click();
		}catch(Throwable t){
			t.getMessage();
			reportFailure("WebElement: "+we+ " coluld not be clicked.");
		}
	}
	
	public void clickAndWait(String locator_clicked, WebElement we){
		test.log(LogStatus.INFO, "Clicking and waiting on - "+locator_clicked);
		int count=10;
		for(int i=0;i<count;i++){
			we.click();
			wait(1);
			if(isElementPresent(we))
				break;
		}
	}
	
	public void enterText(WebElement we, String text){
		try{
			we.sendKeys(text);
		}catch(Throwable t){
			t.getMessage();
			reportFailure("Text: "+text+" could not been entered. And the WebElement is: "+we);
		}			
	}
	
//	navigates to an URL*********************************************************************
	public void navigate(String url){
		try{
			driver.get(url);
		}
		catch(Throwable t){
			t.getMessage();
			reportFailure("Could not navigate to the: " + url);		
		}
	}
	

//	Move the mouse cursor over the page element/hover *********************************************
	public void moveToElement(WebElement we){
		try{
			Actions act = new Actions(driver);
			act.moveToElement(we).build().perform();;
			wait(1);
		}
		catch(Throwable t){
			t.getMessage();
			reportFailure("");
		}
	}
	
//	Need to test
//	Select a value from a drop down list of a web page*********************************************
	public void selectByText(WebElement we, String text){
		try{
			Select select = new Select(we);
		select.selectByVisibleText(text);
		}
		catch(Throwable t){
			t.getMessage();
			reportFailure("");
		}
	}	
	 
	public boolean compareIntegerVals(int actualIntegerVal, int expectedIntegerVal){
		try{
//		  	If this assertion will fail, It will throw exception and catch block will be executed.
			Assert.assertEquals(actualIntegerVal, expectedIntegerVal);
		  }catch(Throwable t){
			  reportFailure("Actual Value: "+actualIntegerVal+" ,Expected Value: "+expectedIntegerVal);
			  
//		  	If Integer values will not match, return false.
			  return false;
		  	}
//		  	If  Integer values match, return true.
		  	return true;
	}
	
//	Wait method which will accept seconds as param
	public void wait(int timeToWaitInSec){
		try {
			Thread.sleep(timeToWaitInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Wait for a page to load method
	public void waitForPageToLoad() {
		wait(1);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state = (String)js.executeScript("return document.readyState");
		
		while(!state.equals("complete")){
			wait(2);
			state = (String)js.executeScript("return document.readyState");
		}
	}
	
	public String getText(WebElement we){
		test.log(LogStatus.INFO, "Getting text from WebElement: "+we);
		return we.getText();

	}
	
	public void acceptAlert(){
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.alertIsPresent());
		test.log(LogStatus.INFO,"Accepting alert");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

//	This will take the screenshot and save it to screenshots location
	public void takeScreenshot(){
		
	    Date d = new Date();
	    String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
	    
	    File scrFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	      FileUtils.copyFile(scrFile, new File(FBConstants.SCREENSHOT_PATH + fileName));
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	}
		
  
	@BeforeSuite
	public void cleanup(){
		System.out.println("Running Before Suite.");
		System.out.println("Current Date & Time: "+TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
		
	}
  
	@AfterMethod
	public void quitReport(){
		
//		This is for Extent Reports to flush if there is a Report
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
	}
	
	/*
	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result){
	 
	//  Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try 
			{	
			    Date d = new Date();
			    String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			    
			//  Call method to capture screenshot
			    File scrFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
	//  Copy files to specific location here it will save all screenshot in our project home directory and
	//  result.getName() will return name of test case so that screenshot name will be same
				FileUtils.copyFile(scrFile, new File(FBConstants.SCREENSHOT_PATH + fileName));
	 
				System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{
	 
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
	}
	
	*/
  
	@AfterSuite
	public void teardown() {
		System.out.println("Running AfterSuite.");
		driver.quit();
	}
}