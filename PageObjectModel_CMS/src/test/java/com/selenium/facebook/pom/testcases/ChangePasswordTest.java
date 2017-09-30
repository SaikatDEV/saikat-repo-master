package com.selenium.facebook.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.pages.LandingPage;
import com.selenium.facebook.pom.pages.settings.GeneralSettingsPage;
import com.selenium.facebook.pom.testcases.base.BaseTest;

	public class ChangePasswordTest extends BaseTest{

		String testCaseName = "Change Password Test";
		
		@Test
		public void test_ChangePassword(){
			test = extent.startTest(testCaseName);
			initEnv("Chrome");
			
//			if(isLoggedIn = false){
//				LaunchPage launchpage = PageFactory.initElements(driver, LaunchPage.class);
//				LoginPage loginpage = launchpage.gotoLoginPage();
//				Object page = loginpage.doLogin(FBConstants.USER_NAME, FBConstants.PASSWORD);
//				
//				LandingPage landingpage = (LandingPage)page;
//			}
			
			LandingPage landingpage = PageFactory.initElements(driver, LandingPage.class);
			GeneralSettingsPage gsettingpage = landingpage.getMenu().gotoSettings();
			
//			clickButton(gsettingpage.passwordEdit);
			gsettingpage.changepassword();
			test.log(LogStatus.PASS, testCaseName +" has been Passed");
		}
	}