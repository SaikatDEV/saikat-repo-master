package project.stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.steps.UISteps;
import project.utils.HelperMethods;

public class UIStepDef {
	
	@Steps

	UISteps uiSteps;
	HelperMethods helper;
	

	@Then("^Verify Landing Page has been loaded$")
	public void verify_Landing_Page_has_been_loaded() throws Exception {
		uiSteps.verify_page_is_loaded();
	}
	
	@Given("^User \"([^\"]*)\" logs in to the application \"([^\"]*)\"$")
	public void user_logs_in_to_the_application(String user, String url) throws Exception {
		uiSteps.user_navigate_to(url);
		uiSteps.user_click_on_Log_in_Button();
		
		String userid = null;
		String password = null;
		
		if (user.equalsIgnoreCase("Administrator")){
			userid =  "admin1@unisys.com";
			password = "(Password1)";
			} else if (user.equalsIgnoreCase("Requestor")){
				userid = "requestor1@unisys.com";
				password = "(Password1)";
			} else if (user.equalsIgnoreCase("Manager")){
				userid = "manager1@unisys.com";
				password = "(Password1)";
		}
		
		uiSteps.user_logged_in_using_userid_and_password(userid, password);
	}

	
	@When("^Add user information with firstName \"([^\"]*)\" , lastName \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void add_user_information_with_firstName_lastName_and_email(String firstName, String lastName, String email) throws Exception {
		uiSteps.click_on_add_user();
//		uiSteps.add_user_information_With_firstName_as(firstName);
//		uiSteps.add_user_information_With_lastName_as(lastName);
//		uiSteps.add_user_information_With_email_as(email);
	}

	/*
	@When("^Add user information with Eqiupment \"([^\"]*)\" , Building \"([^\"]*)\" , Room \"([^\"]*)\" , Date \"([^\"]*)\" and Time \"([^\"]*)\"$")
	public void add_user_information_with_Eqiupment_Building_Room_Date_and_Time(String eqiup, String building, String room, String date, String time) throws Exception {
		uiSteps.add_user_information_With_Eqiupment_as(eqiup);
		uiSteps.add_user_information_With_Building_Room_as(building, room);
		uiSteps.add_user_information_With_Date_Time_as(date, time);
	}

	@Then("^Verify new users has been added after submit$")
	public void verify_new_users_has_been_added_after_submit() throws Exception {
		uiSteps.verify_new_users_has_been_added_successfully();
	}
	
	@Then("^Adminstrator is able to add users to book conference room$")
	public void adminstrator_is_able_to_add_users_to_book_conference_room() throws Exception {
	
	}
	
*/

	@Given("^Go to the User Information Page$")
	public void navigate_to_the_User_Information_Page() throws Exception {
		uiSteps.user_navigate_to("http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com/admin/users");
	}

	@When("^User Information table header displays as \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Information_table_header_displays_as_and(String hdr1, String hdr2, String hdr3, String hdr4) throws Exception {
		uiSteps.user_information_table_header_displays_as(hdr1, hdr2, hdr3 , hdr4);
	}
	
	@Given("^User log out from the App$")
	public void user_log_out_from_the_App() throws Exception {
		uiSteps.user_log_out_from_the_app();
	}
	
}

