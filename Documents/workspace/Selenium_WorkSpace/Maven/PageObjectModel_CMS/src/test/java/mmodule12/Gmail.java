package mmodule12;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.selenium.cms.pom.util.FBConstants;

public class Gmail {

//	public static void main(String[] args) {

	@Test(priority = 1)
	public void loginGmail() {
		System.setProperty("webdriver.chrome.driver", FBConstants.CHROME_DRIVER_EXE);
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", Integer.valueOf(2));
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		

		
		driver.get("https://www.google.com");
		driver.findElement(By.cssSelector("#lst-ib")).sendKeys("Gmail.com");
		driver.findElement(By.cssSelector("#tsf input[type='submit']:nth-child(1)")).click();
		
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		/*
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("hello");
        
        
        emailField.clear();
        int x = emailField.getLocation().x;
        int y = emailField.getLocation().y;
        System.out.println(x +"-----"+ y);
        
        
        
        
    WebElement button = driver.findElement(By.name("signIn"));
    button.click();
    
		
		driver.findElement(By.id("Email")).sendKeys("xx");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.name("signIn")).click();
		
		String text = driver.findElement(By.xpath(".//*[@id='searchText']")).getText();
		System.out.println(text);
		
		
		
		*/
//	}
	
	
}
      //webElement is interface