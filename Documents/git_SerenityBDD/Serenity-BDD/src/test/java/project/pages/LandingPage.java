package project.pages;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import project.utils.HelperMethods;
import project.utils.Utilities;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

/**
 * Page Object for Manifest Generator page
 * 
 * @author Saikat Barua
 *
 */

public class LandingPage extends PageObject {

	HelperMethods helper = new HelperMethods();
	public Utilities util = new Utilities();

	// PAGE OBJECTs are located Here
	// *********************************HEADERs*******************************
	@FindBy(css = ".list-group table > thead")
	private WebElementFacade hdr_UserInfoTable;

	// *********************************CONTAINERs***************************

	// *********************************MENUs*******************************

	// *********************************CHEKBOXs*******************************

	// *********************************FIELDs*******************************
	@FindBy(css = "#okta-signin-username")
	private WebElementFacade fld_UserName;

	@FindBy(css = "#okta-signin-password")
	private WebElementFacade fld_Password;

	@FindBy(css = "css will go here")
	private WebElementFacade fld_SomeField;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewFirstName;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewLasttName;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewEmail;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewBuilding;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewEqipment;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewRoom;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewDate;

	@FindBy(xpath = "xxxxxxx")
	private WebElementFacade fld_NewTime;

	// *********************************TEXTFIELDs*******************************

	// *********************************BUTTONs*******************************
	@FindBy(css = "[title='login']")
	private WebElementFacade btn_Login;

	@FindBy(css = "#okta-signin-submit")
	private WebElementFacade btn_SignIn;

	@FindBy(css = "[title='logout']")
	private WebElementFacade btn_logout;

	@FindBy(css = "xxxxxx")
	private WebElementFacade btn_SubmitNewUser;

	@FindBy(css = "body [type='button']")
	private WebElementFacade btn_AddUserButton;

	// *********************************FORMs*******************************

	// *********************************DDLs*******************************

	// *********************************LNKs*******************************

	// Equipment Pgge
	@FindBy(id = "equipment")
	private WebElementFacade fld_equipment;

	@FindBy(xpath = "//*[contains(text(), 'Add Equipment')]")
	private WebElementFacade btn_addequipment;

	// Building Pgge
	@FindBy(id = "building")
	private WebElementFacade fld_building;

	@FindBy(xpath = "//*[contains(text(), 'Add Building')]")
	private WebElementFacade btn_addbuilding;

	public void clickOnLogin() {
		btn_Login.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		btn_Login.click();
		Log.info("Login button has been clicked on");
	}

	public void enterUseridAndPassword(String userid, String password) {
		fld_UserName.waitUntilPresent().sendKeys(userid);
		fld_Password.waitUntilPresent().sendKeys(password);

		// lnk_SomeThing2.waitUntilVisible();
		// String value = fld_SomeField.getText().trim();
		// Assert.assertTrue("Header does not match", value == "someTitle");

	}

	public void clickonSignIn() {

		btn_SignIn.waitUntilClickable().click();
		Log.info("SignIn button has been clicked on");
	}

	public void landingPageIsLoaded() {
		helper.waitInSeconds(3);
		// lnk_SomeThing2.waitUntilVisible();
		//
		// String value = fld_SomeField.getText().trim();
		// Assert.assertTrue("Header does not match", value == "someTitle");
		//
		// Log.info("LandingPage has been loaded");

	}

	// Logout of the application
	public void logout() {
		Log.info("Logging out of the Applcation");
		btn_logout.waitUntilClickable().click();
		Assert.assertEquals("Login", btn_Login.getText());
		Log.info("Logged out");
	}

	public void addNewUserWithFirstName(String firstName) {
		fld_NewFirstName.waitUntilVisible().click();
		fld_NewFirstName.sendKeys(firstName);
		Log.info("FirstName has been Entered");
	}

	public void addNewUserWithLastName(String lastName) {
		fld_NewLasttName.waitUntilVisible().click();
		fld_NewFirstName.sendKeys(lastName);
		Log.info("LastName has been Entered as " + lastName);
	}

	public void addNewUserWithEmail(String email) {
		fld_NewEmail.waitUntilVisible().click();
		fld_NewFirstName.sendKeys(email);
		Log.info("Email has been Entered as " + email);
	}

	public void selectNewUserWithEquipment(String eqiup) {
		fld_NewEqipment.waitUntilVisible();
		fld_NewEqipment.selectByValue(eqiup);
	}

	public void selectNewUserWithbuildingRoom(String building, String room) {
		fld_NewBuilding.waitUntilVisible();
		fld_NewBuilding.selectByValue(building);
		fld_NewRoom.waitUntilVisible();
		fld_NewRoom.selectByValue(room);
	}

	public void selectNewUserWithDateTime(String date, String time) {
		fld_NewDate.waitUntilVisible();
		fld_NewDate.selectByValue(date);
		fld_NewTime.waitUntilVisible();
		fld_NewTime.sendKeys(time);
	}

	public void verifyNewUserIsAdded() {
		btn_SubmitNewUser.waitUntilClickable().click();
	}

	public void verifyUserTableHeader(String hdr1, String hdr2, String hdr3, String hdr4) {
		hdr_UserInfoTable.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		String[] expectedHdrTitles = { hdr1, hdr2, hdr3, hdr4 };
		boolean actualHdrTitles = helper.stringContainsItemFromList(hdr_UserInfoTable, expectedHdrTitles);
		Assert.assertTrue("Expected Values: " + util.convertArrayToString(expectedHdrTitles), actualHdrTitles);
		Log.info("Header Title has been verified");
	}

	public void clickOnAddUserButton() {
		btn_AddUserButton.waitUntilClickable().click();

		getDriver().get("http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com/admin/users/add");

		helper.waitInSeconds(2);

	}

	// Equipment Page
	public void setEquipmetId(String equipmentId) {
		helper.inputText(fld_equipment, equipmentId, "Set Equipment Id");

	}

	public void addEquipmet() {
		helper.clickElement(btn_addequipment, "Add Equipment");

	}

	// Building Page
	public void setEBuildingId(String equipmentId) {
		helper.inputText(fld_building, equipmentId, "Set Building Id");

	}

	public void addBuilding() {
		helper.clickElement(btn_addbuilding, "Add Building");

	}
}
