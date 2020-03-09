package Scripts;

import org.testng.annotations.Test;

import Generic.BaseClass;
import Generic.ExcelUtility;
import Pages.ActiTimeEnterTimeTrackPage;
import Pages.ActiTimeLogin;

public class TestBuildNo extends BaseClass{
	
	@Test(priority = 1)
    public void verifyBuildNo() throws InterruptedException {
		
		ActiTimeLogin l = new ActiTimeLogin(driver);
		try {
		String UN = ExcelUtility.getCellValue(".//testdata/Book1.xlsx", "Valid", 1, 0);
		String PW = ExcelUtility.getCellValue(".//testdata/Book1.xlsx", "Valid", 1, 1);
		String buildNo = ExcelUtility.getCellValue(".//testdata/Book1.xlsx", "Valid", 1, 2);
		
		l.setUserName(UN);//Entering username
		
		l.setPassword(PW);//Entering the password
		
		l.clickOn();//click on login method
		
		ActiTimeEnterTimeTrackPage hp = new ActiTimeEnterTimeTrackPage(driver);
		
		hp.clickOnHelp(); //click on help dropdown
		
		hp.clickOnAbout(); //click on about
		
		hp.verifyBuildNo(buildNo); // verify the build no
		
		hp.clickClose(); // click on close
		
		hp.clickLogout(); // click on logout
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}


}
