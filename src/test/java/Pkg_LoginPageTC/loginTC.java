package Pkg_LoginPageTC;

import org.testng.annotations.Test;
import Pkg_AppSetup.AppSetupClass;
import Pkg_BusinessLogics.LoginBL;

public class loginTC extends AppSetupClass 
{
	LoginBL lBL= new LoginBL();
	
	
	@Test(priority = 0)
	public void Login()
	{
		lBL.launchApplication(driver, getTestURL());
	}

	
	
	
	
	

}
