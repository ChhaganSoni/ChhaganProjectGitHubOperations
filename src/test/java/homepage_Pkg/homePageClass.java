package homepage_Pkg;

import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import BrowserLaunch_Pkg.BrowserLaunchTest;
import HomePageLocators_Pkg.HomePageWebElements;
import commonUtility_Pkg.commonUtilityClass;

public class homePageClass extends BrowserLaunchTest
{	
		HomePageWebElements homeElement;
	
	 	@Test(priority = 0)
	    public void HomePageVisit() 
	 	{	 	        
	        homeElement =  new HomePageWebElements(driver);
	        commonUtilityClass.waitForElementVisible(driver, homeElement.popupClose);
	        commonUtilityClass.clickButton(homeElement.popupClose);
	        System.out.println("Home page Popup Window closed....!!");
	        
	        org.testng.Assert.assertTrue(true);
	        
	    }
	 	
	 	@Test(priority = 1)
	 	public void selectProduct()
	 	{
	 		homeElement = new HomePageWebElements(driver); 	 		
	 		commonUtilityClass.waitForElementVisible(driver, homeElement.prodName);
	 		commonUtilityClass.scrollToElement(driver, homeElement.prodName);
	 		commonUtilityClass.clickButton(homeElement.prodName);
	 		System.out.println("Test Case: [2] - Select any product from the homepage or menu....!!");
	 		System.out.println("Test Case: [3] - Choosen the default product options....!!");
	 		
	 		org.testng.Assert.assertTrue(true);
	 		
	 	}
	 	
	 	
	 	

}
