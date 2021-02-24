package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Catalog extends Base{
	
	



	public Catalog(WebDriver driver) {
		super(driver);
	}
	
	
	
	/*
	 * Method name: open supplier filter: null Return boolean(True/False):
	 * boolean Author: Hagai
	 */

	public boolean opensupplierfilter() throws InterruptedException {
	click(By.className("cf_title"));
	Thread.sleep(2000);
			return false;
	}
	
	public void selectAllcheckbox() {
	click(By.id("selectAllFilter_check_boxs"));

	
	}
	
	
	public void singelchoose() throws InterruptedException {
		click(By.cssSelector("#\\31 33"));
		//typeTextSubmit(By.className("search_input"),"טסט1");
		click(By.cssSelector("#\31 23"));
		typeTextSubmit(By.cssSelector("#\31 23456"), "");
	}
}

