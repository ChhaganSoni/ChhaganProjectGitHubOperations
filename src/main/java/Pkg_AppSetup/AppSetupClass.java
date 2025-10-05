package Pkg_AppSetup;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import Pkg_CommonUtilities.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AppSetupClass 
{
	
	public static WebDriver driver;
	ReadPropertyFile propFile = new ReadPropertyFile();

	private String TestURL;
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "Environment", "Browser" })
	public void init(String Environment, String Browser) {

		if (Environment.equalsIgnoreCase("QA"))
		{
			driver = startBrowser(Browser);
			setTestURL(propFile.readPropertyFile("QAURL"));
		}
		
	}

	public WebDriver startBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println(browser + " browser launch sucessfully");
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println(browser + " browser launch sucessfully");
		}

		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Defaul browser launch sucessfully");
		}
		return driver;
	}

	/*public void tearDown() {
		try {
			driver.quit();
			System.out.println("Application Closed sucessfully");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver*");
		} catch (Exception e) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver32.exe");
				System.out.println("Application Closed force-fully ");
			} catch (IOException e1) {
			}
		}
	}*/
	
	public String getTestURL() {
		return TestURL;
	}

	public void setTestURL(String testURL) {
		TestURL = testURL;
	}



}
