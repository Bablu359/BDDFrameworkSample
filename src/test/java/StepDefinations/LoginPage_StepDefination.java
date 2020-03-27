package StepDefinations;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

/**
 * Class for Step Definations for Login Page
 * 
 * @author Ashutosh Pradhan
 */

import ApplicationPages.LoginPage;
import Base.DriverScript;
import GenericLibrary.ActionsUtils;
import Listener.ExtentReportListener;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage_StepDefination extends ExtentReportListener {

	LoginPage loginpage = new LoginPage();
	WebDriver driver;

	@Given("^User should on login page of the application$")
	public void user_should_on_login_page_of_the_application() throws Throwable {
		ExtentTest logInfo = null;
		try {

			test = extent.createTest(Feature.class, "Login Page validation ");
			test = test.createNode(Scenario.class, "Verify Home page should get displayed");
			logInfo = test.createNode(new GherkinKeyword("Given"), "User should on login page of the application");
			DriverScript.openURL();
			logInfo.pass("Login page Displayed");
			logInfo.addScreenCaptureFromPath(ActionsUtils.TakeScreenshot());
			


		} catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@When("^User Enter Username and password$")

	public void user_Enter_Username_and_password() throws Throwable {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("Given"), "User Enter Username and password ");
			loginpage.EnterUsernameAndPassword();
			logInfo.pass("Entered UN and Password");
			logInfo.addScreenCaptureFromPath(ActionsUtils.TakeScreenshot());

		} catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@Then("^User Click on the login button and Verify home page should displayed$")
	public void user_Click_on_the_login_button_and_Verify_home_page_should_displayed() throws Throwable {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("Given"),
					"User Click on the login button and Verify home page should displayed ");
			loginpage.ClickOnLoginBtn();
			logInfo.pass("Home page Displayed");
			logInfo.addScreenCaptureFromPath(ActionsUtils.TakeScreenshot());

		} catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

}
