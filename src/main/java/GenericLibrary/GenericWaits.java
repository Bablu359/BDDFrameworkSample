package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverScript;

/**
 * Class for Generic Waits
 * 
 * @author Ashutosh Pradhan
 */

public class GenericWaits extends DriverScript {

	public static void waitForComponentPresence(WebDriver driver, WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForPageToLoad(WebDriver driver, String pageTitle, int maxTry) throws InterruptedException {

		for (int i = 0; i < maxTry; i++) {
			if (driver.getTitle().equals(pageTitle)) {
				break;
			}
			Thread.sleep(1000);
		}
	}

	public static void waitForfewSeconds(WebDriver driver, int timeout) throws InterruptedException {

		Thread.sleep(timeout);
	}

}
