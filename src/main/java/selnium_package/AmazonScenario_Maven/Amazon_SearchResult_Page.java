package selnium_package.AmazonScenario_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_SearchResult_Page {

	WebDriver driver;

	@FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	WebElement selectShoe;

	public void selectProduct() {
		selectShoe.click();
	}

	public Amazon_SearchResult_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
