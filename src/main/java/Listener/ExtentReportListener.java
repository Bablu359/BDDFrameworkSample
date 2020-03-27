package Listener;

/**
 * Class for Extent report Listener for Configuration of report
 * 
 * @author Ashutosh Pradhan
 */

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import GenericLibrary.ActionsUtils;

public class ExtentReportListener {
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;

	public static ExtentReports setUp() {

		String reportLocation = "./ExtentReport/Extent_Report.html";

		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("**Test**");
		report.config().setReportName("**Test**");
		report.config().setTheme(Theme.STANDARD);

		System.out.println("Extent report location initialized");
		report.start();

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "**Test**");
		// extent.setSystemInfo("Operating System", System.getProperty("os.name"));

		System.out.println("System info set in Extent Report");

		return extent;

	}

	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {

		switch (teststatus) {

		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case Failed :", ExtentColor.RED));

			extenttest.error(throwable.fillInStackTrace());

			try {

				extenttest.addScreenCaptureFromPath(ActionsUtils.TakeScreenshot());

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (driver != null) {
				driver.quit();

			}
			break;
		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case Passed :", ExtentColor.GREEN));
			break;
		}
	}

}
