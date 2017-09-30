package com.selenium.cms.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.cms.pom.pages.common.TopMenu;
import com.selenium.cms.pom.testcases.base.BaseTest;

// This will have the common methods
// All page classes will be extending this
public class BasePage extends BaseTest{
	
//	Declare in BasePage
//	It will be available to all child classes
	
//	public static WebDriver driver;
	
//	Every page HAS A TopMenu
//	Declare TopMenu object - here menu is an object
	public TopMenu menu;
	
//	Default/Mandatory constructor but it has no use
	public BasePage(){}
	
	public BasePage(WebDriver driver){
		BaseTest.driver=driver;
		
//		Need to initialize the TopMenu class Elements as soon as driver get initialized
		menu = PageFactory.initElements(driver, TopMenu.class);
	}
	
	public String verifyTitle(String expTitle){
	    return "";
	}
	
//	public boolean isElementPresent(String selector){
//		int s = driver.findElements(By.cssSelector(selector)).size();
//		
//		System.out.println("Here is the Size: "+s);
//		
//		if(s==0){
//			return false;
//		}
//		else
//			return true;
//	}

	
//	Getter method So i can use Encapsulation like : PageClass.getMenu().logout();
	public TopMenu getMenu(){
	    return menu;
	}	
}
