package Scripts;

import org.testng.annotations.Test;

import Generic.BaseClass;
//import Generic.DataProviderClass;
import Generic.ExcelUtility;
import Generic.Lib;
import Pages.ActiTimeLogin;

public class TestInvalidLogin extends BaseClass {

//	@Test(dataProvider = "data-Bank", dataProviderClass = DataProviderClass.class )
//	public void testInvalidLogin(String UN, String PW) {
//		ActiTimeLogin il = new ActiTimeLogin(driver);
//
//		il.setUserName(UN);
//		il.setPassword(PW);
//		il.clickOn();
//		il.verifyLogin();
//
//	}

	@Test
	public void inValidlogin() {
		int rowCount = ExcelUtility.getRowCount(EXCEL_PATH, "Invalid");
		for (int i=1;i<=rowCount;i++){
			
			try {

				String UN = ExcelUtility.getCellValue(EXCEL_PATH, "Invalid", i, 0);
				String PW = ExcelUtility.getCellValue(EXCEL_PATH, "Invalid", i, 1);

				ActiTimeLogin il = new ActiTimeLogin(driver);

				il.setUserName(UN);
				il.setPassword(PW);
				il.clickOn();
				il.verifyLogin();
				if (i<rowCount) Lib.refresh(); // refresh the page

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
