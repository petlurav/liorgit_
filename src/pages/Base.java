package pages;

import java.sql.Connection;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	// WebDriver from test
	public WebDriver driver;

	WebDriverWait wait;
	Actions action;
	Select select;

	public Base(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	/*
	 * Parameters: 1. WebElement 2. Text to type Send keys to web element after
	 * clean
	 */
	public void typeTextSubmit(By by, String text) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable((by)));

		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
		driver.findElement(by).submit();
		Thread.sleep(2000);
	}
	public void sendkey(By by, String text) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable((by)));
		driver.findElement(by).sendKeys(text);
		Thread.sleep(2000);
	}
	
	
	
	/*
	 * Parameters: 1. WebElement click on web element after verify is click able
	 */
	public void click(By by) {
		// Verify the WebElement is click able and then click
		wait.until(ExpectedConditions.elementToBeClickable((by)));
		driver.findElement(by).click();
	}

	
	
	
	public void keys(By by,Keys keys) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable((by)));

		driver.findElement(by).sendKeys(keys);
		
	}
	/*
	 * Parameters: 1. WebElement getText after verify exist
	 */
	public String getText(By by) {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((by)));
		String text = driver.findElement(by).getText();
		
		return text;
		
	}

	
	
	public String getattribute(By by) {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((by)));
		String text = driver.findElement(by).getAttribute("src");
		
		return text;}

	public void ClickAndHold(By by) {
		Actions action=new Actions(driver);
		action.clickAndHold().clickAndHold(driver.findElement(by));
	}
	
	public void MoveToElement(By by) {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(by));
	}

	/*Parameters: selectbytext text tag
	*/
	public void select(  By by,String value ) {
		
		Select select = new Select(driver.findElement(by));
		select.selectByVisibleText(value);
		
			
	}
	/*Parameters: selectbyindex text tag
	*/
	public void selectbyindex(  By by,int value ) {
		
		Select select = new Select(driver.findElement(by));
		select.selectByIndex(value);
		
			
	}
	/*Parameters: 1. click on the webelement name
	*/
	public void clickweb(WebElement text,By by ) {
	text.findElement(by).click();
		
		
	}
}

