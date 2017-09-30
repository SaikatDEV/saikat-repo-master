package com.selenium.cms.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.cms.pom.base.BasePage;
import com.selenium.cms.pom.util.FBConstants;


	public class LaunchPage extends BasePage{
		
//		Constructor will be called when the object will be created
//		And the driver will be passed into the constructor
		public LaunchPage(WebDriver driver) {
				
//			This is calling Parent class constructor and pass driver object into it
			super(driver);
		}
  
		public LoginPage gotoLoginPage(){
			
			driver.get(FBConstants.HOMEPAGE_URL);
			return PageFactory.initElements(driver, LoginPage.class);
		}
		
	}