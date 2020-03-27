package GenericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.DriverScript;
import junit.framework.Assert;

/**
 * Class for Generic Asserts
 * 
 * @author Ashutosh Pradhan
 */

public class GenericAsserts extends DriverScript {

	/** Validate Page title from the Site **/

	public static void ValidatePageTitle(WebDriver driver, String expectedTitle) {
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualtitle);

	}

	/** Validate the text with the expected text **/
	public static void ValidateText(WebDriver driver, WebElement element, String expectedText) {
		String actualtext = element.getText();
		Assert.assertEquals(expectedText, actualtext);

	}

	/** Validate whether element is present **/
	public static void ValidateExistance(WebDriver driver, WebElement element, String ValidationType,
			Boolean expectedState) {

		Boolean actualState = null;
		if (ValidationType == "displayed") {
			actualState = element.isDisplayed();
		}
		if (ValidationType == "enabled") {
			actualState = element.isEnabled();
		}
		if (ValidationType == "selected") {
			actualState = element.isSelected();
		}
		Assert.assertEquals(expectedState, actualState);

	}

	/** Validate the Current URL from the Site **/

	public void ValidateCurrentURL(WebDriver driver, String expectedURL) {
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);

	}

	/** Radio button validation **/
	public static void ValidateRadioBottonExistanceWithValue(WebDriver driver, String elementQueryJs,
			String ValidationType, Boolean expectedState) {

		JavascriptExecutor jsp = (JavascriptExecutor) driver;
		Boolean value = (boolean) jsp.executeScript(elementQueryJs);

		Assert.assertEquals(expectedState, value);

	}

}
