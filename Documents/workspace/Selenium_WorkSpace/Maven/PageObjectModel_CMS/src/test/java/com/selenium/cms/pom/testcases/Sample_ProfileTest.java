package com.selenium.cms.pom.testcases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.cms.pom.pages.LandingPage;
import com.selenium.cms.pom.pages.LaunchPage;
import com.selenium.cms.pom.pages.LoginPage;
import com.selenium.cms.pom.pages.ProfilePage;


public class Sample_ProfileTest{

	WebDriver driver = null;
  
	public Sample_ProfileTest(){}
  
		@Test
		public void testProfile() {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/chromedriver");
   
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", Integer.valueOf(2));
			
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(option);
    
//			Implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			
//			pageFactory class is calling the static mathods
//			Creating object of launchPage and pass the driver instance into this class
//			it also return the LaunchPage object
//			So launchPage driver also pointing to the same Chrome/FireFox driver
			LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
			
//			So we can use launchPage object to call the method
			LoginPage loginPage = launchPage.gotoLoginPage();
			Object page = loginPage.doLogin("asmenterprise.llc@gmail.com", "tg310306");
    
//			As the return type is Object of the method doLogin
			if ((page instanceof LoginPage)) {
				Assert.fail("Login has been Failed !");
			} else if ((page instanceof LandingPage)) {
//				Need to check below
				System.out.println("------Logged in Successfully------");
			}
    
//			Test execution will be in landingPage after pass
//			Object casting - We have to extract the LandingPage from page
//			LandingPage LandingPage = page
			LandingPage landingPage = (LandingPage)page;
    
			ProfilePage profilePage = landingPage.gotoProfilePage();
			profilePage.verifyProfile();
	
			profilePage.verifyTitle("");
			
			profilePage.getMenu().logout();
		}	
	}