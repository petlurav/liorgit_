package utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.common.io.Files;

public class Utilities {
	
	
	public static String getDataFromXML(String fileName, String keyData, int index) throws ParserConfigurationException, SAXException, IOException {
		//	Locate file			
		String path = System.getProperty("user.dir");
		File xmlFile = new File(path +"\\resources\\"+ fileName);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		String value = doc.getElementsByTagName(keyData).item(index).getTextContent();
		
		return value;
	}
	
	
	public static String getProperty(String key) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream(System.getProperty("user.dir") +"\\resources\\"+ "Settings.properties");
		prop.load(input);
				
		String value = prop.getProperty(key);
		
		return value;
	}
	
	//Take screenshot for the ExtentReports
		public static String takeScreenShot(WebDriver driver) throws IOException {
			
			//take snapshot
			TakesScreenshot takescreenshot = (TakesScreenshot)driver;
			
			
			//Get the image file
			File screenshotFile = takescreenshot.getScreenshotAs(OutputType.FILE);
			
			//Create time stamp string for image name
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
			
			//output image
			File destFile = new File(System.getProperty("user.dir") + "\\test-output\\images\\" + timeStamp +".png");
			
			//Create the image
			try {
				Files.copy(screenshotFile, destFile);
			}
			catch(IOException e) {
				System.out.println("Failed to create image..." + System.getProperty("user.dir") + "\\test-output\\images\\" + timeStamp +".png");
			}
			
			//Send back the pagh of the image
			return destFile.getAbsolutePath();
		}
		
		
		
		// Method for getting WebDriver with get baseURL 
		public static void tearDown(WebDriver driver) {
			System.out.println("**********finish test***********");
			driver.quit();

		}

}
