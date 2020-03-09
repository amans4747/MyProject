package Generic;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "data-Bank")
	public static Object[][] dataBank(){
		
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "admin";
		data[1][0] = "manager";
		data[1][1] = "manager";
		data[2][0] = "admin1";
		data[2][1] = "admin2";
//		Object[][] data = {{"admin","admin"},{"manager","manager"},{"asaddf","cvsdvs"}};
		return data;
	}

}
