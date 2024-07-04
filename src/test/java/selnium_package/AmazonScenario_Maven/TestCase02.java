//Login-> Search-> click on 1st product	

package selnium_package.AmazonScenario_Maven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestCase02 {

	@Test
	public void selectProduct() {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		Amazon_Login_Page amazonLogin = new Amazon_Login_Page(driver);
		amazonLogin.userName();
		amazonLogin.continueClick();
		amazonLogin.password();
		amazonLogin.signIn();
		
		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.searchProduct();
		
		Amazon_SearchResult_Page result = new Amazon_SearchResult_Page(driver);
		result.selectProduct();
	}
	
}
