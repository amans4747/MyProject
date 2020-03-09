package Generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



public class BaseClass implements IAutoConstant {
	
	public static WebDriver driver;
	@BeforeSuite
	public void  initializeBrowserMethod(){
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void preCondition(String browser) throws IOException
	{
		if(browser.equals("chrome")) {
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
	
		String iw = Lib.getProperty(CONFIG_PATH, "ImplicitTimeout");
		int timeOutPeriod = Integer.parseInt(iw); 
		driver.manage().timeouts().implicitlyWait(timeOutPeriod, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url=Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
	}
	
	@AfterMethod
	public void postCondition(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()){
			Lib.captureScreenShot(driver, result.getName());
		}
		
		driver.close();
	}
	
}
	
