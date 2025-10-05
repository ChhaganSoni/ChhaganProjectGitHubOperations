package Pkg_CommonMethods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pkg_CommonUtilities.ReadPropertyFile;


public class commonMethods 
{
	//======================================================================================================================
	
		ReadPropertyFile propFile = new ReadPropertyFile();

		Boolean flag = null;
		WebDriverWait wait;
		
		WebDriver driver;
		
		// Launching web application
		// Return type : boolean
		public boolean launchURL(WebDriver driver, String url)
		{
			try {
				driver.get(url);
				driver.manage().window().maximize();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		// Identify the object on UI and highlight the object boundary with RED borde
		// Return type : WebElement
		public WebElement objecLocater(WebDriver driver, By locator) {
			WDWait(driver, locator);
			WebElement objTemp = driver.findElement(locator);
			if (objTemp.isDisplayed() || objTemp.isEnabled()) {
				System.out.println("Debug : object is Visible/Enabled > " + locator);
				try
				{				
					propFile.objHig(driver, objTemp);
				} catch (Exception e) {
					System.out.println("Debug : Object could not be highlighted " + locator);
				}
				return objTemp;

			} else {
				System.out.println("Debug : object has not built > " + locator);
				throw new ElementNotInteractableException(null,null);
			}
		}

		// Global wait method (External Wait)
		public WebElement WDWait(WebDriver driver, By locator) {
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		// Global Fluent wait method
		public Wait<WebDriver> FLWait(WebDriver driver, By locator) {
			Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementNotInteractableException.class);
			return fwait;
		}

		public void listObjecLocater(WebDriver driver, By locator) {
			List<WebElement> objTemp = driver.findElements(locator);
			for (WebElement obj2 : objTemp) {
				if (obj2.isDisplayed()) {
					propFile.objHig(driver, obj2);
				}
			}
		}

		// Set text in textbox and highlight the textbox boundary with RED border
		// Last Update : Oct 29, 2019 by QA
		// Return type : Boolean

		public boolean setText(WebDriver driver, By locator, String txtVar) {
			boolean flag;
			try {
				objecLocater(driver, locator);
				WebElement wd = driver.findElement(locator);
				wd.clear();
				wd.click();
				System.out.println("Before" + wd.getText());
				wd.sendKeys(txtVar);
				System.out.println("After" + wd.getText());
				flag = true;
			} catch (Exception e) {
				flag = false;
			}

			return flag;
		}

		// Get text from the highlight object
		// Created / Update : Dec 2, 2019 by QA
		// Return type : String

		public String getText(WebDriver driver, By locator) {
			try {
				return objecLocater(driver, locator).getText();
			} catch (Exception e) {
				return driver.findElement(locator).getText();
			}

		}

		// Click on Link/Menu
		public boolean clickMenu(WebDriver driver, By locator) {
			WebElement objWE = objecLocater(driver, locator);

			if (objWE.isEnabled()) {
				objWE.click();
				return true;
			} else
				return false;
		}

		public boolean clickLink(WebDriver driver, By locator) {
			WebElement objWE = objecLocater(driver, locator);

			if (objWE.isEnabled()) {
				objWE.click();
				return true;
			} else
				return false;
		}
		
		
		//----------------------------------------------------------------------
		
		public boolean clickElement(WebDriver driver, By locator) {
			WebElement objWE = objecLocater(driver, locator);

			if (objWE.isEnabled()) {
				objWE.click();
				return true;
			} else
				return false;
		}
		
		//----------------------------------------------------------------------
		
		
		// Click on Button if Enabled
		public boolean clickButton(WebDriver driver, By locator) {
			WDWait(driver, locator);
			WebElement objWE = objecLocater(driver, locator);

			if (objWE.isEnabled()) {
				objWE.click();
				return true;
			} else
				return false;

		}

		// Hit Submit button by Click or JS
		public boolean submitButton(WebDriver driver, By locator) {
			WDWait(driver, locator);
			WebElement objWE = objecLocater(driver, locator);

			System.out.println("Debug : testing object " + objWE.getText());

			if (objWE.getAttribute("type") == "hidden") {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", objWE);
				return true;
			} else {
				if (objWE.isEnabled()) {
					objWE.submit();
					return true;
				} else
					return false;
			}
		}

		// Select value from Dropdown based on Visible text
		public boolean selectValues(WebDriver driver, By locator, String txtVar) {
			Select objWE = new Select(objecLocater(driver, locator));
			boolean flag = false;
			try {
				objWE.selectByValue(txtVar);
				flag = true;
			} catch (Exception e) {
				try {
					objWE.selectByVisibleText(txtVar);
					flag = true;
				} catch (Exception e2) {
					try {
						objWE.selectByIndex(1);
						flag = true;
					} catch (Exception e3) {

					}
				}
			}
			return flag;
		}
		

		public boolean selectDDValue(WebDriver driver, By locator, String value) {
			try {
				WebElement objWE = objecLocater(driver, locator);
				Select selectObject = new Select(objWE);
				selectObject.selectByVisibleText(value);
				return true;

			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}

		}

		public boolean isElementPresent(WebDriver driver, By locator) {
			try {
				objecLocater(driver, locator);
				return true;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}
		}

		public boolean onMouseHover(WebDriver driver, By locator) {
			try {
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(locator);
				action.moveToElement(we).click().build().perform();
				return true;

			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}

		}

		public boolean onMouseHover_withoutClick(WebDriver driver, By locator) {
			try {
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(locator);
				action.moveToElement(we).moveToElement(driver.findElement(locator)).build().perform();
				return true;

			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}

		}

		public boolean selectCheckBox(WebDriver driver, By locator) {
			try {
				WebElement objWE = objecLocater(driver, locator);
				if (objWE.isSelected())
					return true;
				else {
					objWE.click();
					return true;
				}
			} catch (NoSuchElementException e) {
				return false;
			}
		}

		// To check spinner visibility on page
		public boolean spinnerCheck(WebDriver driver, By locator) {
			try {
				if (driver.findElement(locator).isDisplayed())
					return true;
				else
					return false;
			} catch (NoSuchElementException e) {
				return false;
			}
		}

		public String currentDate() {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			return (date.format(formatter));
		}
		
		//======================================================================================================================


	
	
	
	
	
	
	
}
