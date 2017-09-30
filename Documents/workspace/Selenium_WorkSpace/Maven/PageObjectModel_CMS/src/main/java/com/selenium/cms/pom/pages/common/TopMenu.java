package com.selenium.cms.pom.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.cms.pom.pages.settings.GeneralSettingsPage;

//	We need to use Encapsulation for all common features of pages
//	TopMenu is common for all page classes
//	All pages HAS A TopMenu
//	TopMenu is encapsulated in all page classes

	public class TopMenu {
		
		@FindBy(css="#userNavigationLabel")
		public WebElement navigation_Label;
		
//		Using xpath which text is Settings
		@FindBy(xpath="//span[text()='Settings']")
		public WebElement settings_Link;
		
//		As this is not Extending to BasePage, Declare Driver
		WebDriver driver;
  
//		Constructor of TopMenu
		public TopMenu (WebDriver driver){
			this.driver = driver;
		}
  
		public void logout(){
			System.out.println("Logging Out");
		}
  
		public GeneralSettingsPage gotoSettings() {
			navigation_Label.click();
			
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("document.getElementById('#userNavigationLabel').click()");
			
			settings_Link.click();
			return PageFactory.initElements(driver, GeneralSettingsPage.class);
		}
	}