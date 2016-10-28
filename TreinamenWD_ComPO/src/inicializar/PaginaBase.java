package inicializar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PaginaBase {

		WebDriver driver;
		
		public PaginaBase(WebDriver driver) {			
			this.driver = driver;
		}
		
		public PaginaBase() {
			System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
			this.driver = new FirefoxDriver();			
		}
		
		public void navegateTo(String url) {
			driver.navigate().to(url);
		}
		
		public WebDriver getDriver() {
			return driver;
		}
		public void closeNavegator() {
			getDriver().quit();
		}

	}
