package project.stepDef;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import project.steps.APISteps;
import project.utils.HelperMethods;

public class APIStepDef {
	
	@Steps
	APISteps apisteps;
	HelperMethods helper;
	

	@Given("^Post Body Data into the Sample App End point \"([^\"]*)\"$")
	public void post_Body_Data_into_the_Sample_App_End_point(String url) throws Exception {
		apisteps.post_body_data_into_the_sample_app_end_point(url);
	}
	
}

