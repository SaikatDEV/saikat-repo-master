package com.selenium.facebook.pom.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.facebook.pom.base.BasePage;

public class GeneralSettingsPage extends BasePage{

	@FindBy(css="#SettingsPage_Content li:nth-child(5) a")
	public WebElement passwordEdit;
	
	public GeneralSettingsPage(WebDriver driver){
		super(driver);
	}
	
	public void changepassword(){
		clickButton(passwordEdit);
	}
}
