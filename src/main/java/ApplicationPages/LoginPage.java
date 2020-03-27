package ApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverScript;
import GenericLibrary.ActionsUtils;
import GenericLibrary.GenericActions;
import GenericLibrary.GenericAsserts;
import GenericLibrary.GenericWaits;
import GenericLibrary.Xls_Reader;

/**
 * Class for Locators & Actions for Home page
 * 
 * @author Ashutosh Pradhan
 */

public class LoginPage extends DriverScript {

	Xls_Reader reader = new Xls_Reader("./ExternalFile/TestData.xlsx");

	/**************************************
	 * Locators
	 **********************************************/

	@FindBy(xpath = "//input[@id='ctl00_wnSidebar_ctl00_userName']")
	WebElement UserNameTB;
	@FindBy(xpath = ".//*[@id='ctl00_wnSidebar_ctl00_userPwd']")
	WebElement PasswordTB;
	@FindBy(xpath = "//div[@id='showButton']/input")
	WebElement loginButton;

	/*********************** Actions ****************************/
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void EnterUsernameAndPassword() throws InterruptedException {
		ActionsUtils.highLighterMethod(driver, UserNameTB);
		String UsernameExcel = reader.getCellData("LoginCredentials", 0, 2);
		GenericActions.DoSendkeys(driver, UserNameTB, UsernameExcel);
		ActionsUtils.TakeScreenshotsForWebElement(UserNameTB, "UserName");
		ActionsUtils.highLighterMethod(driver, PasswordTB);
		String passwordExcel = reader.getCellData("LoginCredentials", 1, 2);
		GenericActions.DoSendkeys(driver, PasswordTB, passwordExcel);
		ActionsUtils.TakeScreenshotsForWebElement(PasswordTB, "Password");
		GenericWaits.waitForfewSeconds(driver, 1000);

	}

	public void ClickOnLoginBtn() throws InterruptedException {
		ActionsUtils.highLighterMethod(driver, loginButton);
		ActionsUtils.TakeScreenshotsForWebElement(loginButton, "loginButton");
		GenericActions.GetHeightAndWidthOfWebElement(loginButton);
		GenericActions.Doclick(driver, loginButton);
		GenericWaits.waitForfewSeconds(driver, 1000);
		GenericAsserts.ValidatePageTitle(driver, "WildCommercial");

	}

}
