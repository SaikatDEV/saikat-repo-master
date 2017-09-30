package com.selenium.facebook.pom.pages;

import com.selenium.facebook.pom.base.BasePage;
import org.openqa.selenium.WebDriver;






	public class ProfilePage extends BasePage{
		
//		This will initialize driver and pass in to the same Chrome WebDriver
		public ProfilePage (WebDriver driver){
			
//			This is calling Parent class constructor and pass driver object into it
			super(driver);
		}
  
		public void verifyProfile() {
			
		}
	}