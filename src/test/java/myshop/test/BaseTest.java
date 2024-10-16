package myshop.test;

import br.com.dbccompany.myshop.factory.selenium.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends BrowserService {

	@Parameters({"browser", "os"})
	@BeforeMethod
	public void openBrowser(String browser, String os) {
		initBrowser("http://www.automationpractice.pl/index.php", browser, os);
	}

	@AfterMethod
	public void closeBrowser() {
		quit();
	}
}