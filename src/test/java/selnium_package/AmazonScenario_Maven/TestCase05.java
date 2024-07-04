//Test case -> Login-> Search-> click on 1st product-> click on add to wishlist-> add to cart-> Select the address        	

package selnium_package.AmazonScenario_Maven;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase05 {

	@Test
	public void selectAddress() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		Amazon_Login_Page amazonLogin = new Amazon_Login_Page(driver);
		amazonLogin.userName();
		amazonLogin.continueClick();
		amazonLogin.password();
		amazonLogin.signIn();

		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.searchProduct();

		Amazon_SearchResult_Page result = new Amazon_SearchResult_Page(driver);
		result.selectProduct();

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> parentChildId = windowHandles.iterator();

		String parentId = parentChildId.next();
		String childId = parentChildId.next();

		driver.switchTo().window(childId);

		Amazon_Product_Page productPage = new Amazon_Product_Page(driver);
		productPage.addToWishlist();

		productPage.viewYourList();

		productPage.addToCart();

		productPage.proceedToCheckOut();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.titleIs("Select a delivery address"));
		Amazon_Address_Page address = new Amazon_Address_Page(driver);
		address.selectAddress();

		address.useThisAddress();

	}
}
