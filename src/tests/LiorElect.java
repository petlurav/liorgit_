package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Catalog;
import pages.Main;
import utilites.GetDriver;
import utilites.Utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class LiorElect {

	// Global variables 
	// Add extent reports
	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\lior.html";

	private WebDriver driver;
	private String baseUrl;
	
	
	//pages
	private Main main;
	private Catalog catalog;
	
	

	@BeforeClass
	public void beforeClass() {
		extent = new ExtentReports(reportPaht);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\resources\\lior-extent-config.xml"));
		baseUrl = "https://www.segment.co.il/";
		driver = GetDriver.getDriver("chrome", baseUrl);
		main = new Main(driver);
		catalog=new Catalog(driver);
		
	}

	
	
	@BeforeMethod
	public void beforeMethod(Method method) throws IOException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
	}
	
	
	
	/*  Prerequisite: verify cart is empty
	/*  	Given: client is in site lior  - main page
	 * 		When: client is get in to the mainpage
	 *  
	 */
	
	@Test(priority = 1, enabled = true, description = "Check login")
	public void login() throws InterruptedException, IOException {	
		main.login();
		
	}
	
	
	/*  Prerequisite: verify cart is empty
	 * 		Given: client is in site superpharm - main page and perform a search to product
	 * 		When: client is clicking add to cart
	 *  	Then: product is added to cart
	 */
	
	@Test(priority = 2, enabled = true, description = "verify open main page")
	public void entrytolior() throws InterruptedException, IOException {	
	
		Assert.assertTrue(main.entrytolior(),"not a catalog page");
		
	}

	
	@Test(priority = 3, enabled = true, description = "open supplier filter")
	public void opensupplierf() throws InterruptedException, IOException {	
		catalog.opensupplierfilter();
		
	}
	
	@Test(priority = 5, enabled = true, description = "selecet all checkbox")
	public void selectAllf() throws InterruptedException, IOException {	
		//catalog.selectAllcheckbox();
		
	}
	
	@Test(priority = 4, enabled = true, description = "singel choose checkbox")
	public void singelshoose() throws InterruptedException, IOException {	
		catalog.singelchoose();
		
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
