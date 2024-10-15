package br.com.dbccompany.myshop.factory.selenium;  import org.openqa.selenium.WebDriver; import org.openqa.selenium.chrome.ChromeOptions; import org.openqa.selenium.edge.EdgeOptions; import org.openqa.selenium.firefox.FirefoxOptions; import org.openqa.selenium.remote.RemoteWebDriver; import org.openqa.selenium.support.ui.WebDriverWait;  import java.net.MalformedURLException; import java.net.URL; import java.time.Duration; import java.util.logging.Level; import java.util.logging.Logger;  public class BrowserService {
	private static final String SELENIUM_GRID_URL = "http://localhost:4444/";
	private static final Logger logger = Logger.getLogger(BrowserService.class.getName());

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();


	public void initBrowser(String url, String browser) {

		try {
			switch (browser.toLowerCase()) {
				case "chrome":
					driver.set(new RemoteWebDriver(new URL(SELENIUM_GRID_URL), new ChromeOptions()));
					break;
				case "edge":
					driver.set(new RemoteWebDriver(new URL(SELENIUM_GRID_URL), new EdgeOptions()));
					break;
				case "firefox":
					driver.set(new RemoteWebDriver(new URL(SELENIUM_GRID_URL), new FirefoxOptions()));
					break;
				default:
					throw new IllegalArgumentException("Navegador não suportado: " + browser);
			}

			wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(30)));
			driver.get().get(url);
			driver.get().manage().window().maximize();

		} catch (MalformedURLException e) {
			logger.log(Level.SEVERE, "A URL do Selenium Grid está incorreta: " + e.getMessage(), e);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro ao inicializar o navegador: " + e.getMessage(), e);
		}
	}

	public void quit() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
			wait.remove();
		}
	}
}