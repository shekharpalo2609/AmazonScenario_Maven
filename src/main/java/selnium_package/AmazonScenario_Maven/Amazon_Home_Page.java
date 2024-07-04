package selnium_package.AmazonScenario_Maven;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Home_Page {

	WebDriver driver;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextField;
	
	public void searchProduct() {
		searchTextField.sendKeys("shoes");
		searchTextField.sendKeys(Keys.ENTER);
	}
	
	public Amazon_Home_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
}
