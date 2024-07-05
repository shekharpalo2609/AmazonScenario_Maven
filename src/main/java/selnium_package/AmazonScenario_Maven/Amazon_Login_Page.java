package selnium_package.AmazonScenario_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Login_Page {

	WebDriver driver;
	
	@FindBy(name="email")
	WebElement emailID;

	@FindBy(id="continue")
	WebElement continueButton;

	@FindBy(id="ap_password")
	WebElement password;

	@FindBy(id="signInSubmit")
	WebElement signInButton;
	
	public void userName() {
		emailID.sendKeys("paloskr26@gmail.com");
	}
	
	public void continueClick() {
		continueButton.click();
	}
	
	public void password() {
		password.sendKeys("*****************");
	}
	
	public void signIn() {
		signInButton.click();
		
	}
	
	public Amazon_Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
