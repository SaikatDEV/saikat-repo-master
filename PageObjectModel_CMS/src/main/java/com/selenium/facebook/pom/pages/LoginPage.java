package com.selenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.facebook.pom.base.BasePage;


	public class LoginPage extends BasePage{
		
//		@FindBy is a PageFactory Annotations
		@FindBy(css="#email")
		public WebElement email;
		
		@FindBy(css="#pass")
		public WebElement passWord;
		
		@FindBy(css="input[value='Log In']")
		public WebElement login_button;
  
		
//		WebDriver declaration goes to BasePage class as LoginPage extending BasePage
//		public WebDriver driver;
		
		public LoginPage(WebDriver driver){
//			As we are extending to BasePage, we don't need to write below
//			driver is initialized to the same Chrome WebDriver
//			this.driver = driver;
			
//			This is calling Parent class constructor and pass driver object into it
			super(driver);
		}
  

//		This can take to the multiple pages, depending on the scenario
//		SO it will return Object class as we dont know what will be returned
		public Object doLogin(String userName, String Password) {
			
			email.sendKeys(userName);
			passWord.sendKeys(Password);
			
//			If click doesn't work, we can try below
//			passWord.sendKeys(Keys.ENTER);
			login_button.click();

//			validate logic
			boolean loginSuccess = true;
			if (loginSuccess) {
				
//				This below will create the LandingPage object and return the LandingPage class
				return PageFactory.initElements(driver, LandingPage.class);
			}else
//				If not logged_in, return loginPage
				return PageFactory.initElements(driver, LoginPage.class);
		}
	}