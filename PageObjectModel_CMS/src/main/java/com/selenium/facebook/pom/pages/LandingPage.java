package com.selenium.facebook.pom.pages;

import com.selenium.facebook.pom.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




	public class LandingPage extends BasePage{
		
		@FindBy(css="#userNav .linkWrap.noCount")
		public WebElement profile_link;
  
		public LandingPage(WebDriver driver){
			
//			This is calling Parent class constructor and pass driver object into it
			super(driver);
		}
  

		public ProfilePage gotoProfilePage(){
			profile_link.click();
			
//			This will return the ProfilePage object and will initialize the Elements of that page
			return PageFactory.initElements(driver, ProfilePage.class);
		}
	}