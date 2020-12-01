package Com_ActiTime_Test;
import org.testng.annotations.Test;

import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Page.actiTIMEEnterTimeTrackPage;
import Com_ActiTime_Page.actiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void ValidLoginLogout()
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String lgTitle  = ExcelData.getData(file_path, "TC01", 1, 2);
		String epTItle = ExcelData.getData(file_path, "TC01", 1, 3);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTIMEEnterTimeTrackPage ep = new actiTIMEEnterTimeTrackPage(driver);
		//to verify login page title
		lp.verifyTitle(lgTitle);
		//to enter valid user name
		lp.enteruserName(un);
		//to enter valide password
		lp.enterPassword(pw);
		//click on loging button
		lp.clickOnLogin();
		//to verify Enter time track page title
		lp.verifyTitle(epTItle);
		// to click on logout
		ep.clickOnLogoutButton();
		//to verify login page title
		lp.verifyTitle(lgTitle);
	}
}
