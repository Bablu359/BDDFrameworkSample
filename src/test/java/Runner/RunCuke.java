package Runner;
/**
 * Class for Runcuke(To provide the input/path for featurefile,StepdefinationFile & Tags)
 * 
 * @author Ashutosh Pradhan
 */


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/java/FeatureFile/SmokeTest.feature" }, glue = { "StepDefinations" }, tags = {
		"@SmokeTest" }, plugin = { "json:target/cucumber.json",
				"html:target/site/cucumber-pretty" }, monochrome = true, dryRun = false)

public class RunCuke extends AbstractTestNGCucumberTests {

}

