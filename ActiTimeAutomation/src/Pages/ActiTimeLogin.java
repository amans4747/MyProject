package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ActiTimeLogin {
	@FindBy(id="username")
	private WebElement UnTextBox;
	@FindBy(name="pwd")
	private WebElement PwTextBox;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	private WebElement errorMsg;
	
	public ActiTimeLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un) {
	UnTextBox.sendKeys(un);
	}
	public void setPassword(String pw) {
		PwTextBox.sendKeys(pw);
	}
	public void clickOn(){
		loginBtn.click();
	}
	
	public void login(String un, String pw){
		UnTextBox.sendKeys(un);
		PwTextBox.sendKeys(pw);
		loginBtn.click();
	}
   public void verifyLogin() {
	   Assert.assertTrue(errorMsg.isDisplayed());
   }
}
