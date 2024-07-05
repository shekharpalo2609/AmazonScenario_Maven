package selnium_package.AmazonScenario_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Address_Page {

	WebDriver driver;
	
	@FindBy(xpath = "(//span[@class='break-word'])[5]")
	WebElement selectAddressOption;
	
	public void selectAddress() {
		selectAddressOption.click();
	}
	
	@FindBy(xpath = "(//input[@type='submit'])[2]")
	WebElement useThisAddressButton;
	
	public void useThisAddress() {
		useThisAddressButton.click();
	}
	
	public Amazon_Address_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
