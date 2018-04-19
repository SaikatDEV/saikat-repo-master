package project.steps;

import jline.internal.Log;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pages.LandingPage;
import project.pages.SamplePage;
import project.utils.HelperMethods;

/**
 * Scenario steps, can use across multiple scenarios (test cases)
 * @author FDEEXJD
 *
 */
@SuppressWarnings("serial")
public class UISteps extends ScenarioSteps {
	
	SamplePage samplePage;
	LandingPage landingPage;
	HelperMethods helper;

	@Step
	public void user_navigate_to(String url) {
		getDriver().get(url);
		Log.info("User navigated to the URL = " + url);
		
    	getDriver().manage().window().maximize();
    	Log.info("Browser window has been Maximized");
	}

	@Step
	public void user_logged_in_using_userid_and_password(String userid, String password) {
		landingPage.enterUseridAndPassword(userid, password);
		landingPage.clickonSignIn();

	}

	@Step
	public void verify_page_is_loaded() {
		landingPage.landingPageIsLoaded();
	}

	@Step
	public void user_click_on_Log_in_Button() {
		landingPage.clickOnLogin();
	}

	@Step
	public void user_log_out_from_the_app() {
		landingPage.logout();
	}

	@Step
	public void add_user_information_With_firstName_as(String firstName) {
		landingPage.addNewUserWithFirstName(firstName);
	}
	
	@Step
	public void add_user_information_With_lastName_as(String lastName) {
		landingPage.addNewUserWithLastName(lastName);
	}

	@Step
	public void add_user_information_With_email_as(String email) {
		landingPage.addNewUserWithEmail(email);
	}

	@Step
	public void add_user_information_With_Eqiupment_as(String eqiup) {
		landingPage.selectNewUserWithEquipment(eqiup);
	}

	@Step
	public void add_user_information_With_Building_Room_as(String building, String room) {
		landingPage.selectNewUserWithbuildingRoom(building, room);
	}

	@Step
	public void add_user_information_With_Date_Time_as(String date, String time) {
		landingPage.selectNewUserWithDateTime(date, time);
	}

	@Step
	public void verify_new_users_has_been_added_successfully() {
		landingPage.verifyNewUserIsAdded();
	}

	@Step
	public void user_information_table_header_displays_as(String hdr1, String hdr2, String hdr3, String hdr4) {
		landingPage.verifyUserTableHeader(hdr1, hdr2, hdr3, hdr4);
	}

	@Step
	public void click_on_add_user() {
		landingPage.clickOnAddUserButton();
		
	}
}
