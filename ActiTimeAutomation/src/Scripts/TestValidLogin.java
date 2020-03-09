package Scripts;

import org.testng.annotations.Test;

import Generic.BaseClass;
import Generic.ExcelUtility;
import Pages.ActiTimeEnterTimeTrackPage;
import Pages.ActiTimeLogin;

public class TestValidLogin extends BaseClass{
	
	
	@Test(priority = 0)
	public void validlogin() {
		try {
		ActiTimeLogin l = new ActiTimeLogin(driver);
		
		String UN = ExcelUtility.getCellValue(".//testdata/Book1.xlsx", "Valid", 1, 0);
		l.setUserName(UN);//Entering username
		
		String PW = ExcelUtility.getCellValue(".//testdata/Book1.xlsx", "Valid", 1, 1);
		l.setPassword(PW);//Entering the password
		
		l.clickOn();//click on login method
		
		ActiTimeEnterTimeTrackPage hp = new ActiTimeEnterTimeTrackPage(driver);
		
		hp.clickLogout(); // click on logout
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
