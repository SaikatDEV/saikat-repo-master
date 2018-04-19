package project.stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import project.steps.SampleSteps;
import project.utils.HelperMethods;

public class SampleStepDef {
	
	@Steps
	SampleSteps steps;
	HelperMethods helper;
	
	/*
	@Given("^Login to Pride using test user as \"([^\"]*)\"$")
	public void login_to_Pride_using_test_user_as(String testuser){
		steps.go_to_entitlement_page();
		
		if (testuser.equalsIgnoreCase("SUPERUSER")) {
			testuser = "ZDGAGR5";
			Serenity.setSessionVariable("testuser").to("ZDGAGR5");
			
		}else if (testuser.equalsIgnoreCase("OFFICER")) {
			testuser = "ZDGAGR8";
			Serenity.setSessionVariable("testuser").to("ZDGAGR8");
			
		}else if (testuser.equalsIgnoreCase("READONLY")) {
			testuser = "HHH1YJE";
			Serenity.setSessionVariable("testuser").to("HHH1YJE");
			
		}else if (testuser.equalsIgnoreCase("SUPERVISOR")) {
			testuser = "ZDGAGR7";
			Serenity.setSessionVariable("testuser").to("ZDGAGR7");
			
		}else if (testuser.equalsIgnoreCase("LSS")) {
			testuser = "ZDGAGR4";
			Serenity.setSessionVariable("testuser").to("ZDGAGR4");
			
		}else if (testuser.equalsIgnoreCase("FIELDOFFICER")) {
			testuser = "ZDGAGR2";
			Serenity.setSessionVariable("testuser").to("ZDGAGR2");
			
		}else if (testuser.equalsIgnoreCase("HQ")) {
			testuser = "ZDGAGR1";
			Serenity.setSessionVariable("testuser").to("ZDGAGR1");
		}
	}
	*/
	
	@Given("^I use UserName as \"([^\"]*)\" and Valid Password as \"([^\"]*)\"$")
	public void i_use_UserName_and_Valid_Password_as(String username, String password){
		steps.loginToUSCIS(username, password);

	}
	
	@Given("^Navigate to the App end point \"([^\"]*)\"$")
	public void navigate_to_the_App(String url) throws Throwable {
		steps.navigate_to_App(url);
	}
	
	@Given("^Verify the status code is \"([^\"]*)\" for resource \"([^\"]*)\"$")
	public void verify_the_status_code_for_resource(int statusCode, String value) throws Throwable {
	    steps.verify_status_code_resource(statusCode, value);
	}
	
	@Given("^Verify new student is added with status code of \"([^\"]*)\"$")
	public void verify_new_student_added_with_status_code(int statusCode) throws Throwable {
		steps.new_student_added_with_status_code(statusCode);
	}
	
	@Then("^Verify the student is added to the application$")
	public void verify_the_student_is_added_to_the_application() throws Exception {
		steps.verify_the_student_is_added_to_the_application();
	}
	
	@Then("^Update the student info$")
	public void update_the_student_info() throws Exception {
		steps.update_student_info();
	}
//	
//	@Given("^Verify student first name \"([^\"]*)\" is available for resource \"([^\"]*)\"$")
//	public void verify_student_first_name_is_available_for_resource(String firstName, String value) throws Exception {
//		steps.verify_student_first_name_is_available_for_resource(firstName, value);
//	}
}

