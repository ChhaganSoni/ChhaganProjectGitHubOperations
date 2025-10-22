package Pkg_BusinessLogics;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import Pkg_CommonMethods.commonMethods;


public class LoginBL 
{
	//LoginOR lOR = new LoginOR();
	commonMethods cm = new commonMethods();
	//RWExcelUtility rwExcel = new RWExcelUtility();
	
	Map<String, String> map=new HashMap<String, String>();	

	public void launchApplication(WebDriver driver, String url)
	{
		try
		{
			if (cm.launchURL(driver, url))
			{
				System.out.println("URL Launched successfully...!!");
			}
			else
			{
				System.out.println("URL not launched...!!");
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception LoginBL :---->>"+e);
		}
	}

	/*public void readLoginData(WebDriver driver, Map<String, String> setData) throws IOException
	{
		try
		{
			if(setData!=null)
			{
				cm.WDWait(driver, lOR.enterEmail);
				cm.setText(driver, lOR.enterEmail, setData.get("UserName"));		
				Thread.sleep(2000);
				cm.setText(driver, lOR.enterPassword, setData.get("UserPassword"));
				Thread.sleep(2000);
				cm.clickButton(driver, lOR.clickLogin);
				Thread.sleep(4000);	
				
				if(driver.getCurrentUrl().contains("http://qaprojects.rishabhsoft.com/user/mydashboard"))
				{
					map.put(setData.get("UsrID"), "Pass");
					Thread.sleep(2000);
					cm.clickElement(driver, lOR.loggedInHome);
					cm.WDWait(driver, lOR.LoggedOUT);
					cm.clickElement(driver, lOR.LoggedOUT);
					Thread.sleep(3000);					
				}
				else
				{
					map.put(setData.get("UsrID"), "Fail");					
				}					
			}			
		}
		catch (InterruptedException e)
		{
			System.out.println("Exception readLoginData :---->>"+e);
		}
		*/
		
		//System.out.println("Map result is ::---->>>"+map);		
		
		//rwExcel.writeResultExl("Sheet1",map);
		
}




