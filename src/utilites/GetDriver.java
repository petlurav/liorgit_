package utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class GetDriver {

	

	// Method for getting WebDriver
	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;

		if (browser.equals("chrome")) {
			// Set the location of the Google Chrome driver exe file by set the system
			System.setProperty("webdriver.chrome.driver", "C:\\JAR\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			// Set system property
			System.setProperty("webdriver.gecko.driver", "C:\\JAR\\Geco\\geckodriver.exe");
			// Initialize web driver
			driver = new FirefoxDriver();
		}
		
		//add general wait for elements
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// maximize window
		driver.manage().window().maximize();
		return driver;

	}
	
	
	// Method for getting WebDriver with get baseURL 
		public static WebDriver getDriver(String browser, String baseUrl) {
			WebDriver driver = null;

			if (browser.equals("chrome")) {
				// Set the location of the Google Chrome driver exe file by set the system
				System.setProperty("webdriver.chrome.driver", "C:\\JAR\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				// Set system property
				System.setProperty("webdriver.gecko.driver", "C:\\JAR\\Geco\\geckodriver.exe");
				// Initialize web driver
				driver = new FirefoxDriver();
			}
			
			//add general wait for elements
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			
			//add maximu time waiting for page to load
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			
			// maximize window
			driver.manage().window().maximize();
			
			//Get baseURL
			driver.get(baseUrl);
			return driver;

		}
		
		
		
	

}
