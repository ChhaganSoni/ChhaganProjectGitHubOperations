package HomePageLocators_Pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageWebElements 
{  
	WebDriver driver;  
    public HomePageWebElements(WebDriver driver) 
    {
    	 this.driver = driver;
         PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//a[@class='closebtn']")
    public WebElement popupClose;
   
    @FindBy(xpath = "//div[@class='productDetailsBox']//p[@class='productName'][normalize-space()='Indoor Banners']")
    public WebElement prodName; 
}
