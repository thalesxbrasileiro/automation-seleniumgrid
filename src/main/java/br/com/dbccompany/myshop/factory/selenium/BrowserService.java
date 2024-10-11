package br.com.dbccompany.myshop.factory.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserService {

    public static WebDriver driver;
    public static WebDriverWait wait;

	public void initBrowser(String url) {

		try {
			ChromeOptions options = new ChromeOptions();
			options.getBrowserName();

			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.get(url);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			System.err.println("A URL do Selenium Grid está incorreta: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro ao inicializar o navegador: " + e.getMessage());
			e.printStackTrace();
		}
	}

    public void quit() {
		driver.quit();
    }

}
