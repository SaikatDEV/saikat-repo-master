package project.steps;

import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.utils.APICommonUtils;
import project.utils.HelperMethods;

import org.junit.Assert;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * Scenario steps, can use across multiple scenarios (test cases)
 * @author FDEEXJD
 *
 */
@SuppressWarnings("serial")
public class APISteps extends ScenarioSteps {
	
	HelperMethods helper;

	@Step
	public void post_body_data_into_the_sample_app_end_point(String url) {
		Log.info("Step - get id after added Student");
		
		Response loginres = given()
//				.proxy("",80)
				.headers("Content-Type", "application/json")
				.body(APICommonUtils.reqTestBodyasMap)
				.log().all()
				.when().post(url);
		System.out.println("------------------------------------");
		
		loginres.prettyPrint();
						
		
		
		JsonPath jsonPathEvaluator = loginres.jsonPath();
		
	

		String first_name = jsonPathEvaluator.get("msg");
		Log.info("New added student first_name = " + first_name);
//		Serenity.setSessionVariable("newId").to(first_name);
//		
//		Assert.assertTrue("Data was not added", first_name.equalsIgnoreCase("TestFirstName2"));	
	}
}
