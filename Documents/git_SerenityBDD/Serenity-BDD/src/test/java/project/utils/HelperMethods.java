package project.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

public class HelperMethods extends PageObject {
	public Utilities util = new Utilities();
	EnvironmentVariables environmentVariables;

	public void ignoreStaleElementError(WebElementFacade webElement, long timeOutInSeconds) {
		// new WebDriverWait(getDriver(),
		// timeoutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));

		long time1 = System.currentTimeMillis();
		try {
			webElement.isCurrentlyEnabled();
		} catch (Exception t) {
			new WebDriverWait(getDriver(), timeOutInSeconds).ignoring(RuntimeException.class)
					.until(ExpectedConditions.elementToBeClickable(webElement));
			boolean value = webElement.isCurrentlyEnabled();
			Log.info("Ignored Exception and current element enability is: " + value);
			long time2 = System.currentTimeMillis();
			Log.info("Total time taken to Ignore Error is= " + (time2 - time1) / 1000 + " Seconds");
		}
	}

	public void scrollIntoViewJS(WebElementFacade webElement) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
		Log.info("JS Scrolled into an Element: " + webElement);
	}

	public void clickOnElementJS(WebElementFacade webElement) {
		scrollIntoViewJS(webElement);
		ignoreStaleElementError(webElement, 15);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", webElement);
		Log.info("JS Clicked on an Element: " + webElement);
	}

	public String clickOnElemenByTextfromListElements(List<WebElementFacade> webelements, String Text) {
		String value = null;

		List<WebElementFacade> links = webelements;
		for (int i = 0; i < links.size(); i++) {

			links.get(i).waitUntilVisible();
			if (links.get(i).getText().trim().equals(Text)) {
				value = links.get(i).getText().trim();

				scrollIntoViewJS(links.get(i));
				links.get(i).withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible().click();
				Log.info(value + " has been selected from the list");
				break;
			}
		}
		return value;
	}

	public String clickOnElemenByIndexfromListElements(List<WebElementFacade> webelements, int ElementIndex) {
		String value = null;
		List<WebElementFacade> links = webelements;
		for (int i = 0; i < links.size(); i++) {
			links = webelements; // this step is must, because whenever you go
									// to other page all store webelements in a
									// list will washout
			if (links.size() != 0) {
				value = links.get(ElementIndex - 1).getText();
				links.get(ElementIndex - 1).click();
				break;
			} else if (links.size() == 0) {
				System.out.println("There is no Scan/Alarm is available to select at this moment");
			}
		}
		return value;
	}

	public void clickOnElemenUntilExists(List<WebElementFacade> webelements) {
		int i = webelements.size();
		Log.info("Total Element Count: " + i);
		while (i > 0) {
			waitInSeconds(1);
			webelements.get(0).withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible().click();
			i--;
		}
	}

	// This function will return True if the String contains items
	// How to use it?
	// boolean value = stringContainsItemFromList(fld_Locator, {"word1",
	// "word2", "word3"});
	public boolean stringContainsItemFromList(WebElementFacade WebElement, String[] items) {
		String inputStr = WebElement.getText();
		for (int i = 0; i < items.length; i++) {
			if (!inputStr.contains(items[i].trim())) {
				return false;
			}
		}
		return true;
	}

	// Wait method which will wait in Seconds as Param - This method is only for
	// troubleshoot purpose
	public void waitInSeconds(int timeToWaitInSec) {
		try {
			Thread.sleep(timeToWaitInSec * 1000);
			Log.info("Hold Execution for " + timeToWaitInSec + " Secs");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeStable(WebElementFacade webElement) {
		int count = 0;
		int maxTries = 20;
		while (true) {
			try {
				webElement.getSize();
			} catch (Throwable e) {
				waitInSeconds(1);
				Log.info("Retry for the Element");
				if (++count == maxTries)
					throw e;
			}
		}
	}

	public void isElementStable(WebElementFacade webElement) {
		boolean isStable = false;
		int count = 0;
		Point elementLocation = webElement.getLocation();
		int initTop = elementLocation.y;
		int initLeft = elementLocation.x;
		while (!isStable) {
			if (initTop == webElement.getLocation().y && initLeft == webElement.getLocation().x) {
				count++;
			} else {
				count = 0;
				initTop = elementLocation.y;
				initLeft = elementLocation.x;
			}

			if (count == 2) {
				Log.info("Waiting for element '" + webElement + "' to be Visible");
				isStable = true;
			}

			try {
				Thread.sleep(200);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	public void waitForLoad(WebDriver driver) {
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	// This function will return True if the ListElements contains Text
	// How to use it?
	public boolean isTextExistInListElements(List<WebElementFacade> webelements, String Text) {
		List<WebElementFacade> links = webelements;
		for (int i = 0; i < links.size(); i++) {
			links.get(i).waitUntilVisible();
			// waitInSeconds(1);
			if (links.get(i).getText().trim().equals(Text)) {
				return true;
			}
		}
		return false;
	}

	public String currentWebDriver() {
		String currentDriverName = null;

		currentDriverName = environmentVariables.getProperty("webdriver.remote.driver");
		if (currentDriverName == null) {
			currentDriverName = environmentVariables.getProperty("webdriver.driver");
			Log.info("Automation Test is Running on Local Machine: " + System.getenv().get("COMPUTERNAME"));

		} else if (currentDriverName != null) {
			// This will Print the IP Address from Remote Machine
			try {
				Log.info(
						"Automation Test is Running on Remote Machine: " + InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Log.info("Another way of getting RunTime Driver: " +
		// ((WebDriverFacade) getDriver()).getProxiedDriver());
		if (currentDriverName.contains("ie")) {
			return currentDriverName.trim();
		} else if (currentDriverName.contains("chrome")) {
			return currentDriverName.trim();
		}
		return null;
	}

	public void VerifyButtonIsNotAvailable(WebElementFacade webElement, String buttonValue) {
		webElement.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		boolean value = webElement.getText().contains(buttonValue);
		Assert.assertFalse(buttonValue + " button is Present !", value);
	}

	public void VerifyButtonIsAvailable(WebElementFacade webElement, String buttonValue) {
		webElement.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		boolean value = webElement.getText().contains(buttonValue);
		Assert.assertTrue(buttonValue + " button is not Present !", value);
	}

	public void switchToChildWindow() throws Exception {
		// log.debug("Switch to Popup Window");
		String childWindow = null, mainwindow = null;
		@SuppressWarnings("unused")
		int counter = 1;
		for (String popup : getDriver().getWindowHandles()) {
			// log.debug("WindowHandles " + counter + ":" + popup + "Window
			// Title:" + getDriver().getTitle());
			getDriver().switchTo().window(popup);

			if (getDriver().getTitle().equals("Biometric Dashboard")) {
				mainwindow = getDriver().getWindowHandle();
				Serenity.setSessionVariable("mainwindowhandle").to(mainwindow);
				// log.debug("Main Window handle Saved : " + mainwindow);

			} else {
				childWindow = getDriver().getWindowHandle();
				Serenity.setSessionVariable("childWindow").to(childWindow);
				// log.debug("Child Window handle Saved : " + childWindow);
			}
			counter++;
		}

		// log.debug("Windows Present are mainwindow:" + mainwindow + "
		// childWindow :" + childWindow);

		getDriver().switchTo().window(childWindow);

	}

	public void getWindowHandle(String windowTitle) throws Exception {
		Thread.sleep(5000);
		// log.info("Capture Window Handle:" + windowTitle);

		for (String windowHandle : getDriver().getWindowHandles()) {
			// log.debug(getDriver().getWindowHandles());
			getDriver().switchTo().window(windowHandle);
			// log.debug("Window:" + getDriver().getTitle() + ":" +
			// windowHandle);
			if (getDriver().getTitle().equals(windowTitle)) {
				Serenity.setSessionVariable("childwindow").to(windowHandle);
			} else {
				Serenity.setSessionVariable("parentwindow").to(windowHandle);
			}
		}
	}

	public void switchToWindow(String windowTitle) throws Exception {
		// log.info("Switch to Window:" + windowTitle);
		// String propkey = windowTitle.trim().replace(" ", "");
		getDriver().switchTo().window(Serenity.sessionVariableCalled("childwindow"));
		// getDriver().switchTo().window(props.get("childwindow"));
		// log.info("Switched to Window:" + getDriver().getTitle());
		Thread.sleep(2000);
		getDriver().manage().window().maximize();
	}

	public void uploadImages(String inputString, String element) throws Exception {
		try {

			WebElement upload = getDriver().findElement(By.xpath(element));
			// String use_hub = page.app.cfg.gets("use_hub");
			String use_hub = SerenitySystemProperties.getProperties()
					.getValue(ThucydidesSystemProperty.WEBDRIVER_REMOTE_DRIVER);

			// log.info("use_hub set to >" + use_hub + "<");
			if (use_hub != null && !use_hub.isEmpty()) {
				((RemoteWebElement) upload).setFileDetector(new LocalFileDetector());
				// log.info("Remote Hub");

			} else {
				inputString = inputString.replaceAll("/", "\\\\");
			}
			Thread.sleep(2000);
			((JavascriptExecutor) getDriver()).executeScript(
					"arguments[0].style.display='block'; arguments[0].style.visibility='visible'; "
							+ "arguments[0].style.height='1px'; arguments[0].style.width='1px'; arguments[0].style.opacity=1",
					upload);

			// log.info("Java Script Executed");
			// log.info("File Path is :" + inputString);

			upload.sendKeys(inputString);
			Thread.sleep(2000);

		} catch (Exception ex) {
			ex.printStackTrace();
			// log.info("Could'nt upload data !" + ex.getMessage());
		}
	}

	public boolean checkElementPresent(org.openqa.selenium.By by) throws InterruptedException {
		return checkElementPresent(by, 60);

	}

	public boolean checkElementPresent(org.openqa.selenium.By by, int time) throws InterruptedException {
		// log.debug("Check Element Present :" + by);

		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		List<WebElement> popupElem = getDriver().findElements(by);
		// log.debug("Pop:" + popupElem);
		boolean isElementPresent;
		long endTime = 0;
		if (popupElem.size() != 0) {
			isElementPresent = true;
			// log.debug("Popup Element : " + popupElem + ":" +
			// isElementPresent);

		} else {
			isElementPresent = false;
			endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(time);
			// log.debug("End Time : " + endTime);
		}

		while (isElementPresent == false) {
			Thread.sleep(1);
			List<WebElement> popupAfter = getDriver().findElements(by);
			if (!popupAfter.isEmpty()) {
				isElementPresent = true;
				// log.debug("Popup Element : " + popupElem + ":" +
				// isElementPresent);
				break;
			}
			if (System.currentTimeMillis() > endTime) {
				break;
			}

		}
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// log.debug("Check Element Present Ended");
		return isElementPresent;

	}

	//Enter text into web element
    public void inputText(WebElementFacade WebElement, String inputtxt, String logmsg) {
        Log.info(logmsg + ":" + inputtxt);
        WebElement.waitUntilVisible();
        WebElement.clear();
        WebElement.sendKeys(inputtxt);

    }
    
    //Click a WebElement
    public void clickElement (WebElementFacade WebElement, String logmsg) {
        Log.info(logmsg);
        WebElement.waitUntilClickable().click();
        
    }
    
    //Select Value from Text
    public void selectFromList(WebElementFacade WebElement, String selecttxt, String logmsg) {
        Log.info(logmsg + ":" + selecttxt);
        WebElement.waitUntilVisible();
        WebElement.selectByVisibleText(selecttxt);

    }
    
    //Return Text for Attribute
    public String verifyText( WebElementFacade WebElement)  {
        return WebElement.getText();
        
    }
    
    //Return Value for Attribute Specified
    public String verifyAttribute( WebElementFacade WebElement, String attributename)  {
        return WebElement.getAttribute(attributename);
        
    }
}
