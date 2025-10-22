package BrowserLaunch_Pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunchTest 
{	
	protected static WebDriver driver;
	@Parameters("browser")
	@BeforeSuite
	public void setUp(@Optional("chrome") String browser) 
	{
		switch (browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();	
	        driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();  
            driver.manage().window().maximize();
			break;
		
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
		driver.get("https://www.bannerbuzz.com/");
		System.out.println("Test Case: [1] - User navigates to the home....!!");
				
	}
}
