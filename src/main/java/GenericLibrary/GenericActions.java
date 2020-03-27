package GenericLibrary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Base.DriverScript;

/**
 * Class for Generic Actions
 * 
 * @author Ashutosh Pradhan
 */

public class GenericActions extends DriverScript {

	/** Click on the Element **/

	public static void Doclick(WebDriver driver, WebElement element) {

		element.click();

	}

	/** Enter Text inside text field **/
	public static void DoSendkeys(WebDriver driver, WebElement element, String Text) {

		element.sendKeys(Text);

	}

	/** DoubleClick on the Element **/
	public static void DoDoubleClick(WebDriver driver, WebElement element) {

		Actions a = new Actions(driver);
		a.doubleClick(element);

	}

	/** To Clear the text Field and updating it with new value **/
	public static void DoclearTextFieldAndUpdateWithNewValue(WebDriver driver, WebElement element, String Text) {

		element.click();
		element.clear();
		element.sendKeys(Text);

	}

	/** Click an Element using Action Class **/
	public static void ActionClick(WebDriver driver, WebElement ActionClickelement) {
		Actions a = new Actions(driver);
		a.moveToElement(ActionClickelement).click().perform();

	}

	/** Selecting the Value from the Suggestion list **/

	public static void SuggestionSelect(WebDriver driver, List<WebElement> element, String text) {
		for (WebElement webElement : element) {
			if (webElement.getText().contains(text)) {
				webElement.click();

			}
		}

	}

	/** Select a value from a dropdown **/
	public static void SelectDropdownValue(WebDriver driver, WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	/** ScrollDown the page **/
	public static void DoScrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

	}

	/** Get title of child Window & return to Parent page **/

	public static void GetTitleAndCloseChildTab(WebDriver driver) {

		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println(driver.switchTo().window(parent).getTitle());
	}

	/** Switch To Child window/Next tab **/

	public static void SwitchToNextTab(WebDriver driver) {

		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

			}
		}
	}

	/*** Select Single Checkbox based on the name ***/
	public static void SelectSingleCheckbox(List<WebElement> elementID, WebDriver driver, String text) {
		for (WebElement webElement : elementID) {
			if (webElement.getText().contains(text)) {
				webElement.click();
			}
		}

	}

	/*** Select List of Checkbox elements ***/

	public static void SelectAllCheckbox(List<WebElement> elementID, WebDriver driver) {
		for (WebElement webElement : elementID) {

			webElement.click();

		}

	}

	/*** MouseHover to click the required element ***/
	public static void MouseHoverToClick(WebDriver driver, WebElement element) {

		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
		element.click();

	}

	/*** Get Current date and Time ***/

	public static String GetCurrentDateAndTime() {
		String str = null;

		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {

		}
		return str;

	}

	/*** Get WebElement Height,Width & X-Y Co-ordinates ***/

	public static void GetHeightAndWidthOfWebElement(WebElement element) {
		Rectangle ElementRect = element.getRect();
		System.out.println(ElementRect.getHeight());
		System.out.println(ElementRect.getWidth());
		System.out.println(ElementRect.getX());
		System.out.println(ElementRect.getY());

	}
}
