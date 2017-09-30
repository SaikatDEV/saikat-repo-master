package com.selenium.cms.pom.pages;

import org.openqa.selenium.WebDriver;

import com.selenium.cms.pom.base.BasePage;






	public class ProfilePage extends BasePage{
		
//		This will initialize driver and pass in to the same Chrome WebDriver
		public ProfilePage (WebDriver driver){
			
//			This is calling Parent class constructor and pass driver object into it
			super(driver);
		}
  
		public void verifyProfile() {
			
		}
	}