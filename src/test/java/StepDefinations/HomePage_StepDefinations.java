package StepDefinations;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import ApplicationPages.HomePage;
import Base.DriverScript;
import GenericLibrary.ActionsUtils;
import Listener.ExtentReportListener;
import cucumber.api.java.en.Then;

/**
 * Class for Step Definations for Home Page
 * 
 * @author Ashutosh Pradhan
 */

public class HomePage_StepDefinations extends ExtentReportListener {

	HomePage homePage = new HomePage();
	WebDriver driver;

	@Then("^User Click on the Logout Button$")
	public void user_Click_on_the_Logout_Button() throws Throwable {

		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("Given"), "User Click on the Logout Button");
			homePage.ClickLogoutBtn();
			logInfo.pass("Logout Successfully");
			logInfo.addScreenCaptureFromPath(ActionsUtils.TakeScreenshot());

		} catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

}
