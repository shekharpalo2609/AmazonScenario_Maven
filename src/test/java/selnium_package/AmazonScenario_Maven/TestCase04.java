//Test case -> Login-> Search-> click on 1st product-> click on add to wishlist-> add to cart        	

package selnium_package.AmazonScenario_Maven;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium_package.listener.ListenerClass;

@Listeners(ListenerClass.class)
public class TestCase04 extends ListenerClass{

	@Test
	public void addProductToCart() {

		driver = new ChromeDriver();
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
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in", "Test case 04 failed!");

	}
}
