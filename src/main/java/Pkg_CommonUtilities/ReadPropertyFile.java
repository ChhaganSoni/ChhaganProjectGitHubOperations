package Pkg_CommonUtilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadPropertyFile 
{
	Properties property;
	
	public String readPropertyFile(String key)
	{
		String value = null;
		try {
			property = new Properties();
			FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\DataFolder\\EnvData.properties");
			property.load(fin);
			value = property.getProperty(key);
		} catch (Exception e) {
			System.out.println("Error while reading property file");
			return null;
		}
		return value;
	}
	
	// Highlight the Object in progress on Web UI
	public void objHig(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid green'", element);
	}	
	

}
