package myshop.test;

import br.com.dbccompany.myshop.factory.selenium.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BrowserService {

	@BeforeMethod
	public void openBrowser(){
		initBrowser("http://www.automationpractice.pl/index.php");
	}

	@AfterMethod
	public void closeBrowser(){
		quit();
	}

}
