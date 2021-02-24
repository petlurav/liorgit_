package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Create_dn  extends Base{
	
	public Create_dn(WebDriver driver) {
		super(driver);
	}
	
	public void dnopen() throws InterruptedException {
		
		click(By.cssSelector("#v5-menu > li:nth-child(3)"));
		click(By.xpath("//*[@id=\"v5menuItem_2628_551\"]/div[2]/div"));
	}
		 public void datelist(int month,String years,String day) { 
			 click(By.id("ContainerForm"));	
			 selectbyindex(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-month"), month);
		     select(By.cssSelector("#ui-datepicker-div > div > div > select.ui-datepicker-year"), years);
		     List<WebElement> columns=driver.findElements(By.tagName("td"));
	         for (WebElement cell: columns){  
	         if (cell.getText().equals(day)){
	         clickweb(cell, By.linkText(day));
	         break; }	}}
	 	
 	
	   public void dndate() {
		   click(By.cssSelector("#componentBox_v5formcomponent_120_3854_2800_1 > div.componentTitle"));
	   }
	         
	         
    

	 }

