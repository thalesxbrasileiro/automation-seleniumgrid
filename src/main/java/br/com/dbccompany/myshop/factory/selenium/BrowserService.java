package br.com.dbccompany.myshop.factory.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserService {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

	public void initBrowser(String url, String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), options));
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions options = new EdgeOptions();
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), options));
			} else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), options));
			}
			wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(30)));
			driver.get().get(url);
			driver.get().manage().window().maximize();
		} catch (MalformedURLException e) {
			System.err.println("A URL do Selenium Grid está incorreta: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro ao inicializar o navegador: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void quit() {
		driver.get().quit();
	}
}