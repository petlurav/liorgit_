package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Main extends Base{

	

	public Main(WebDriver driver) {
		super(driver);
	}

	/*
	 * Method name: searchProduct Method param: product name (String) Return value:
	 * boolean Author: Hagai
	 */

	public boolean login() throws InterruptedException {
		
		
		WebElement login =driver.findElement(By.linkText("כניסת משתמשים"));
		login.click();
		Actions action=new Actions(driver);
		Set<String> windows = driver.getWindowHandles();
		System.out.println("print handel num"  + windows.size());
		int index = 0;

		
		for (String h : windows) {
			System.out.println(h);
			if (index == 1) {
				
		driver.switchTo().window(h);
			}
		index = +1;
		}
	     sendkey(By.id("UserName"), "dimitry");
	     sendkey(By.id("Password"),"@aniel042");
	     click(By.className("mdl-checkbox__label"));
	     Thread.sleep(2000);
	     click(By.name("LoginBtn"));
		
		return true;
	}

	/*
	 * Method name: open main page lior Method param: null Return value: boolean
	 * Author: dmitry
	 */

	public boolean entrytolior () throws InterruptedException {
		click(By.cssSelector("#my-systems > form > ul > li:nth-child(11) > button "));
		//String paganame= getText(By.xpath("//*[@id=\"reportTitle\"]"));
		//if (paganame.contains("קטלוג פריטים"))
		//	return true;
	//	else
			return false;
			
	}
	
	
	
	
	
	
		
	
	
	
	
	
	
}
