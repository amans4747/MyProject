
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiTimeEnterTimeTrackPage {
	@FindBy(xpath = "//td[@class='menuCell navCell']//div[3]")
	private WebElement helpButton;
	@FindBy(xpath = "//a[contains(text(),'About your actiTIME')]")
	private WebElement aboutLink;
	@FindBy(xpath ="//span[contains(text(),'build')]")
	private WebElement buildNo;
	@FindBy(id ="aboutPopupCloseButtonId")
	private WebElement closeButton;
	@FindBy(id ="logoutLink")
	private WebElement logoutButton;
	
	Actions a;

	public ActiTimeEnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
	}

	public void clickOnHelp() {
		a.moveToElement(helpButton).click().build().perform();
	}

	public void clickOnAbout() {
		aboutLink.click();
	}
	public void verifyBuildNo(String ebuildNo) throws InterruptedException {
		Thread.sleep(3000);
		String abuildNo = buildNo.getText();
		Reporter.log("abuildNo: "+abuildNo, true);
		Assert.assertEquals(abuildNo, ebuildNo);
		
		
	}
	public void clickClose() {
		closeButton.click();
	}
	public void clickLogout() {
		logoutButton.click();
	}
}
