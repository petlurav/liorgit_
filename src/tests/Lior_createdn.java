package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Catalog;
import pages.Create_dn;
import pages.Main;
import utilites.GetDriver;
import utilites.Utilities;

public class Lior_createdn {
	
	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\liorDN.html";
    private Main main;
    
    private Create_dn create_dn;
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeClass() {
		extent = new ExtentReports(reportPaht);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\resources\\liorDN-extent-config.xml"));
		baseUrl = "https://www.segment.co.il/";
		driver = GetDriver.getDriver("chrome", baseUrl);
		main = new Main(driver);
		
		
		create_dn =new Create_dn(driver);
	}
		
		@BeforeMethod
		public void beforeMethod(Method method) throws IOException {
			myTest = extent.startTest(method.getName());
			myTest.log(LogStatus.INFO, "Starting test", "Start test");
		}
	
		@Test(priority = 1, enabled = true, description = "Check login")
		public void login() throws InterruptedException, IOException {	
			main.login();
			
		}
		@Test(priority = 2, enabled = true, description = "verify open main page")
		public void entrytolior() throws InterruptedException, IOException {	
		
			main.entrytolior();
			
		}
		@Test(priority = 3, enabled = true, description = "verify open DN page")
		public void opendn() throws InterruptedException, IOException {	
		create_dn.dnopen();		
		}
		
		@Test(priority = 4, enabled = true, description = "choose date")
		public void choosedate() throws InterruptedException, IOException {	
			create_dn.datelist(4,"1987", "23");
		}

		@Test(priority = 4, enabled = true, description = "open dn datepicker")
		public void dndate() throws InterruptedException, IOException {	
			create_dn.dndate();
		}
		
		
		
		
		
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {

			if (result.getStatus() == ITestResult.FAILURE) {
				myTest.log(LogStatus.FAIL, "Test failed: " + result.getName());
				myTest.log(LogStatus.FAIL, "Test failed reason: " + result.getThrowable());
				myTest.log(LogStatus.FAIL, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
			}
			else {
				myTest.log(LogStatus.PASS, result.getName(), "Verify successful ");
				myTest.log(LogStatus.PASS, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));

			}

			myTest.log(LogStatus.INFO, "Finish test", "Finish test ");
			extent.endTest(myTest);
		
			//return to base URL 
			//driver.get(baseUrl);
		}

		@AfterClass
		public void afterClass() {
			extent.flush();
			extent.close();
			//driver.quit();

		}

	
	

}
