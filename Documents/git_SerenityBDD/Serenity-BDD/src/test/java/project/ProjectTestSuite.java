package project;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 *Runner class for tests with cucumber
 * @author FDEEXJD
 *
 */
// run with tags, if you want to avoid running all features under process_flights directory
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/" , plugin = { "html:target/cucumber", "json:target/cucumber/cucumber.json", "pretty:target/cucumber/cucumber-pretty.txt",
                                                                                       "usage:target/cucumber/cucumber-usage.json", "junit:target/cucumber/cucumber-results.xml" })
public class ProjectTestSuite {

}


