package HomePageLocators_Pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageLocator 
{
	public WebDriver driver;

	public ProductPageLocator(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Select Design Method']")
	public WebElement selectDesignBTN;

	@FindBy(xpath = "//div[@class='haveAnArtwork']/label[@class='controls controlRadio']")
	public WebElement clickUploadAtWork;

	@FindBy(xpath = "//*/input[@accept=\".png, .ai, .psd, .jpg, .tiff, .cdr, .pdf, .eps, .ps, .svg, .jpeg, .gif, .bmp, .tif, .jfif, .heic, .doc, .docx, .ppt, .pptx\"]")
	public WebElement browseFile;

	@FindBy(xpath = "//*[text()='Add to Cart']")
	public WebElement AddtoCart;

	@FindBy(xpath = "//input[@name=\"quantity\"]")
	public WebElement AlterProductQTY;

	@FindBy(xpath = "//div[@class='MainpopupMinicart']")
	public WebElement popup_MiniCART;

}
