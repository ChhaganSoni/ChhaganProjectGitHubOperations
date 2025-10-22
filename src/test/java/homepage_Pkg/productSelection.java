package homepage_Pkg;

import org.testng.Assert;
import org.testng.annotations.Test;
import BrowserLaunch_Pkg.BrowserLaunchTest;
import HomePageLocators_Pkg.ProductPageLocator;
import commonUtility_Pkg.commonUtilityClass;

public class productSelection extends BrowserLaunchTest
{	
	ProductPageLocator ProductEle;	
	@Test(priority = 0)
    public void productAdding() throws InterruptedException 
 	{	     
		ProductEle = new ProductPageLocator(driver); 
		System.out.println("Product Adding....!!");
		System.out.println("Driver initialized: " + (driver != null));
			
		commonUtilityClass.waitForElementVisible(driver, ProductEle.selectDesignBTN);		
		boolean visibleEle = ProductEle.selectDesignBTN.isEnabled();		
		System.out.println("Select Design Button is visible :::----> "+visibleEle);		
		      
		commonUtilityClass.waitForElementVisible(driver, ProductEle.selectDesignBTN);		
        commonUtilityClass.clickButton(ProductEle.selectDesignBTN);        
        System.out.println("Test Case:[4] - Clicked on “Select Design Method.” successfully....!!");        
                       
        commonUtilityClass.waitForElementVisible(driver, ProductEle.clickUploadAtWork);        
        commonUtilityClass.switchToPopupWindow(driver);
        System.out.println("Script switches the Window successfully");
        
        commonUtilityClass.waitForElementVisible(driver, ProductEle.clickUploadAtWork);        
        commonUtilityClass.clickButton(ProductEle.clickUploadAtWork); 
        System.out.println("Test Case: [5] - Choosen the “Upload Artwork” option successfully....!!");
                        
        boolean isEnabledBtn = ProductEle.browseFile.isEnabled();
        System.out.println("Browse File Button is enabled ::----->"+isEnabledBtn);                
        
        //commonUtilityClass.waitForElementVisible(driver, ProductEle.browseFile);
        Thread.sleep(40000); 
        ProductEle.browseFile.sendKeys("D:\\Documentssss\\OneDrive\\Desktop\\CustomerCopyCL.docx");   
        //ProductEle.browseFile.sendKeys("./src/test/resources/FileContainer/29619626.docx");
        System.out.println("Test Case: [6] - Uploaded any file from local system....!!");
        
        Assert.fail("Failed to upload File");
        
       commonUtilityClass.waitForElementVisible(driver, ProductEle.AddtoCart);       
       commonUtilityClass.clickButton(ProductEle.AddtoCart);       
       System.out.println("Test Case: [7] - Click on “Add to Cart.”...!!");       
       System.out.println(" User Moves Add to Cart Page...!!");
       
       
       commonUtilityClass.waitForElementVisible(driver, ProductEle.AlterProductQTY);       
       boolean isPresent = ProductEle.AlterProductQTY.isDisplayed();
       System.out.println("Add to Cart - Element is Displayed ::---->"+isPresent);
       
       
       commonUtilityClass.waitForElementVisible(driver, ProductEle.AlterProductQTY);       
       commonUtilityClass.clearAndTypeIntoTEXTField(driver, ProductEle.AlterProductQTY, "5");
       System.out.println("Test Case: [8] - On the cart page, update the quantity to 5....!!");
       
       
       commonUtilityClass.waitForElementVisible(driver, ProductEle.popup_MiniCART);       
       commonUtilityClass.clickButton(ProductEle.popup_MiniCART);
       System.out.println(" Entered product Quantity has been updated successfully....!!");
       
      
        
    }
	
}
