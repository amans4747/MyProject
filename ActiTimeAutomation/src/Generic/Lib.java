package Generic;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Lib extends BaseClass {
	public static void refresh() {
		driver.navigate().refresh();
	}

	public static String getProperty(String CONFIG_PATH, String Key) throws IOException {
		String value = "";
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(CONFIG_PATH);
		prop.load(file);
		value = prop.getProperty(Key);
		return value;
	}
	
	public static void captureScreenShot(WebDriver driver, String testCaseName) {
		
		Date d = new Date();
		String currentDate = d.toString().replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./screenshots/"+testCaseName+"_"+currentDate+".png");
		try {
			Files.copy(srcFile,dstFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
