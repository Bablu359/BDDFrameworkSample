package ApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverScript;
import GenericLibrary.ActionsUtils;
import GenericLibrary.GenericActions;
import GenericLibrary.GenericWaits;

/**
 * Class for Locators & Actions for Home page
 * 
 * @author Ashutosh Pradhan
 */
//Declare for JavaScript Executer for validate radio button
//static String quickNameMatchresultquery = "return $(\"input[type='radio'][name='SearchType'][value='QuickNameMatch']\").is(':checked')";

public class HomePage extends DriverScript {
	/********************** Locators **********************************************/
	@FindBy(linkText = "Logout")
	WebElement LogoutLink;

	/*********************** Actions ****************************/
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickLogoutBtn() throws InterruptedException {

		ActionsUtils.highLighterMethod(driver, LogoutLink);
		ActionsUtils.TakeScreenshotsForWebElement(LogoutLink, "LogoutButton");
		GenericActions.Doclick(driver, LogoutLink);

		GenericWaits.waitForfewSeconds(driver, 2000);
	}

}
