package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = {"stepDefinitions"},
		tags = "@activity1 or @activity2 or @activity4 or @activity5 or @activity3",
		publish = true,
		plugin = {
			"pretty",
			"html:src/reports/HTML_Reports.html",
			"json:src/reports/JSON_Reports.json",
			"junit:src/reports/XML_Reports.xml"
			},
		monochrome = true
		)

public class testRunner {

}
