package Com_ActiTime_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Page.actiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority = 2)
	public void InvalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		//to verify login page title
		lp.verifyTitle(title);
		int rc= ExcelData.getRowCount(file_path, "TC02");
		for(int i =1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			Reporter.log("User name = "+un,true);
			//to enter invalid user name
			lp.enteruserName(un);
			Reporter.log("Password = "+pw,true);
			//to enter invalid password
			lp.enterPassword(pw);
			//to click on login button
			lp.clickOnLogin();
			String aErrorMessger = lp.verifyErrorMessage();
			String eErrorMessage = ExcelData.getData(file_path, "TC02", 1, 2);
			//verify error message
			Assert.assertEquals(aErrorMessger, eErrorMessage);
			Reporter.log("=============================",true);
			Thread.sleep(1000);		
		}
		
	}

}
