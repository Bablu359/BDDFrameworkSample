package GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.DriverScript;

/**
 * Class for Highlight Element before Actions
 * 
 * @author Ashutosh Pradhan
 */

public class ActionsUtils extends DriverScript {

	public static void highLighterMethod(WebDriver driver, WebElement elementToHighlight) {
		try {
			String originalStyle = elementToHighlight.getAttribute("style");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int i = 0; i < 2; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						elementToHighlight);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", elementToHighlight);
				Thread.sleep(150);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*** Take Screenshots of Web Page ***/

	public static String TakeScreenshot() throws IOException {
		Date d = new Date();
		String Dest = "target/ScreenShots/";

		File file = new File(".");

		file.getAbsoluteFile();

		Dest = file.getAbsoluteFile().toString().replace(".", "").replace("\\", "/") + Dest;
		String s1 = d.toString();
		String s2 = s1.replaceAll(":", "_");
		TakesScreenshot scr = (TakesScreenshot) driver;
		File SourceFile = scr.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(Dest + s2 + ".png");
		FileUtils.copyFile(SourceFile, DestFile);
		System.out.println(DestFile.getAbsolutePath().toString());
		return DestFile.getAbsolutePath().toString();

	}

	/*** Take Screenshots For Web Elements ***/

	public static void TakeScreenshotsForWebElement(WebElement element, String filename) {
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/WebElements-ScreenShots/" + filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
