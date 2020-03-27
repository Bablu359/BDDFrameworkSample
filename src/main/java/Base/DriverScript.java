package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Class for Suite Setup
 * 
 * @author Ashutosh Pradhan
 */
public class DriverScript {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;

	public DriverScript() {

		try {

			prop = new Properties();
			fis = new FileInputStream("./Config/config.properties");
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("No File Found " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void init() {
		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
//			driver = new ChromeDriver();

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("ie")) {
//			System.setProperty("webdriver.ie.driver", "./Browsers/IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "");
//			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void openURL() {
		driver.get(prop.getProperty("SiteForwardURL"));

	}

	public static void tearDown() {
		driver.quit();
	}

}
