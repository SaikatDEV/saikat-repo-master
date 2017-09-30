package com.selenium.facebook.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.LandingPage;
import com.selenium.facebook.pom.pages.LaunchPage;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.testcases.base.BaseTest;
import com.selenium.facebook.pom.util.FBConstants;

	public class LoginTest extends BaseTest{
  
		String testCaseName = "Login Test";
		
		@Test(priority=1)
		public void test_Login(){
			
//			This is logging - Will show as a Test Title
			test = extent.startTest(testCaseName);
    
//			Calling method from BaseTest
			initEnv("Chrome");
			LaunchPage launchpage = PageFactory.initElements(driver, LaunchPage.class);
			LoginPage loginpage = launchpage.gotoLoginPage();
			
			test.log(LogStatus.INFO, "username= " + FBConstants.USER_NAME +" & password= "+ FBConstants.PASSWORD);
			Object page = loginpage.doLogin(FBConstants.USER_NAME, FBConstants.PASSWORD);
    
			if (page instanceof LoginPage) {
				reportFailure("Could not Login");
			}
			else if (page instanceof LandingPage) {
				
				
//				LandingPage landingPage = (LandingPage)page;
				
//				This will pass the test with a pass symbol
				test.log(LogStatus.PASS, testCaseName + " has been Passed");
				
//				To fail the test
//				test.log(LogStatus.FAIL, "Login test has been Failed");
			}
		}
  
		@Test(priority=2)
		public void test_profile() { 
			test = extent.startTest("Profile Test");
    
			initEnv("Chrome");
			LandingPage landingpage = (LandingPage)PageFactory.initElements(driver, LandingPage.class);
			landingpage.gotoProfilePage();
//			takeScreenshot();
    
			test.log(LogStatus.PASS, "Profile Test Passed");
		}
  
		@Test(priority=5)
		public void test_1() {
			String testCaseName = "Test Something 1";
			
			test = extent.startTest(testCaseName);
			initEnv("Chrome");
			reportFailure(testCaseName+" has been failed");

		}
  
		@Test(priority=4)
		public void test_2() {
			test = extent.startTest("Test 2");
			initEnv("Chrome");
			test.log(LogStatus.PASS, "2 Test Passed");
		}
  
		@Test(enabled=false)
		public void test_3() {
			String testCaseName = "Test Case 3";
			
			test = extent.startTest(testCaseName);
			initEnv("Chrome");

			reportFailure(testCaseName+" has been failed");
		}
  
		@Test(priority=3)
		public void test_4() {
			test = extent.startTest("Test 4");
			initEnv("Chrome");
			test.log(LogStatus.FAIL, "4 Test Failed");
		}
	}