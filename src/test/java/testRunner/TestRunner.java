package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = ".//Features/",
			glue = {"stepDefinitions"},
		//	tags = "@SanityTest",
			dryRun = false,
			monochrome = true,
			plugin = {"pretty", "html:test-output.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
					
		)

public class TestRunner {

}
