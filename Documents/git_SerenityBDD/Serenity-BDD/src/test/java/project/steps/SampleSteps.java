package project.steps;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.RestAssured;

//import org.apache.commons.logging.Log;

//import io.restassured.RestAssured;
//import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pages.SamplePage;
import project.utils.HelperMethods;
import project.utils.SampleStudentClass;
import project.utils.Utilities;

/**
 * Scenario steps, can use across multiple scenarios (test cases)
 * @author FDEEXJD
 *
 */
@SuppressWarnings("serial")
public class SampleSteps extends ScenarioSteps {

	SamplePage samplePage;
	HelperMethods helper;
	
	static String firstName = Utilities.getRandomNumber_Str(10000) + "SampleFirst1";
	static String lastName = Utilities.getRandomNumber_Str(10000) + "SampleLast"; 
	static String programme = Utilities.getRandomNumber_Str(10000) + "ComputerScience"; 
	static String email = Utilities.getRandomNumber_Str(10000) + "sampleEmail1@google.com";
	static int studentId;
	
    @Step
    public void go_to_entitlement_page() {
    	
    	String currentWebDriver = helper.currentWebDriver();
    	Serenity.setSessionVariable("runTimeWebDriver").to(currentWebDriver);
//    	Log.info("Current WEBDRIVER is => " + currentWebDriver);
    	
    	samplePage.open();
//    	To navigate to the URL
    	getDriver().navigate().to("http://localhost:8085/student/list");
    	getDriver().manage().window().maximize();
    }

    @Step
	public void navigate_to_App(String url) {
		RestAssured.baseURI=url;

//		Log.info("Base url = " + url);
	}

    @Step
	public void verify_status_code_resource(int statusCode, String value) {
    	SerenityRest.rest().given()
		.when().get(value)
		.then().log().all()
		.statusCode(statusCode);
	}

    @Step
	public void new_student_added_with_status_code(int statusCode) {
    	SampleStudentClass student = new SampleStudentClass();
    	
    	ArrayList<String> courses = new ArrayList<String>();
    	courses.add("JAVA");
    	courses.add("C++");
    	
//    	Create the Student Object with values
    	student.setFirstName(firstName);
    	student.setLastName(lastName);
    	student.setEmail(email);
    	student.setProgramme(programme);
    	student.setCourses(courses);
    	
    	SerenityRest.rest().given()
//		.contentType(ContentType.JSON)
		.log().all()
		.when().body(student).post()
		.then().log().all()
		.statusCode(statusCode);
	}
/*
    @Step
	public void verify_student_first_name_is_available_for_resource(String firstName2, String value){
//    	"findAll{it.firstName==''}.get(0)"
    	
    	String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		
		String fname = Serenity.sessionVariableCalled("first_name");
		System.out.println("---******2*****---" + fname);
    	
    	HashMap<String, Object> hashValue  = SerenityRest.rest().given()
		.when().get(value)
		.then().log().all()
		.statusCode(200)
		.extract().path(p1+fname+p2);
    	
    	Log.info("Name ======" + hashValue);
    	studentId = (int) hashValue.get("id");
    	
    	Log.info("id ======" + studentId);
	}
    
    */

    @Step
	public void loginToUSCIS(String username, String password) {
		getDriver().get("http://uscis.com/");
		helper.waitInSeconds(5);
	}

    @Step
	public void verify_the_student_is_added_to_the_application() {
//    	"findAll{it.firstName==''}.get(0)"
    	
    	String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
    	
    	HashMap<String,Object> value = SerenityRest.rest().given()
    	.when()
    	.get("/list")
    	.then().log().all()
    	.statusCode(200)
    	.extract().path(p1+firstName+p2);
    	
//    	Log.info("The value is: " + value);
//    	assertThat is a Junit method, hasValue is Hamcrest
    	assertThat(value, hasValue(firstName));
    	studentId = (int) value.get("id");
	}
    
    @Step
    public void update_student_info(){
    	SampleStudentClass student = new SampleStudentClass();
    	
    	ArrayList<String> courses = new ArrayList<String>();
    	courses.add("JAVA");
    	courses.add("C++");
    	
    	firstName = firstName + "_Updated";
    	
//    	Create the Student Object with values
    	student.setFirstName(firstName);
    	student.setLastName(lastName);
    	student.setEmail(email);
    	student.setProgramme(programme);
    	student.setCourses(courses);
    	
    	SerenityRest.rest().given()
//		.contentType(ContentType.JSON)
		.log().all()
		.when().body(student).put("/" +studentId)
		.then().log().all();
    }
}
