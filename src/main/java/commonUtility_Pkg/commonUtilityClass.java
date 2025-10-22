package commonUtility_Pkg;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtilityClass 
{	
	public static void waitForElementVisible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void scrollToElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}
	
	  public static void clickButton(WebElement element) 
	  {
	        if (element.isDisplayed() && element.isEnabled()) 
	        {
	            element.click();
	        } 
	        else 
	        {
	            throw new RuntimeException("Element is either not visible, or not enabled.");
	        }
	    }
	  
	  public static void switchToPopupWindow(WebDriver driver) 
	  {
		  String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();

	        for (String handle : allWindowHandles) 
	        {
	            if (!handle.equals(mainWindowHandle)) 
	            {
	                driver.switchTo().window(handle);
	                System.out.println("Switched to popup window: " + handle);
	                break;
	            }
	        }
	  }
	
	  public static void clearAndTypeIntoTEXTField(WebDriver driver, WebElement TextfieldLocator, String newValue) 
	  {
	        try 
	        {
	        	TextfieldLocator.clear(); // Clears existing text
	        	TextfieldLocator.sendKeys(newValue); // Types new value
	            System.out.println("Text field updated with: " + newValue);
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Failed to update text field: " + e.getMessage());
	        }
	    }
}
