package com.training.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


/**
 *   in this class the path for screenshot is hard coded, please refer to others.properties file 
 *   the entry is kept, and this path can be changed from properties file 
 */
public class ScreenShot {

	private WebDriver driver; 
	private static Properties properties;
	
	// the driver information will be given by selenium test case 
	public ScreenShot(WebDriver driver){
		this.driver = driver; 
		
	}
	
	public void captureScreenShot() throws IOException{
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		String path = properties.getProperty("screenshot.folder");
		String fileName ="";

		GregorianCalendar calendar = new GregorianCalendar(); 
		
		int date =  calendar.get(Calendar.DATE); 
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND); 
		
		
		fileName = new Integer(date).toString() + "-" + new Integer(minute).toString() +"-" +
					new Integer(second).toString() +".png"; 
		
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +fileName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	public void captureScreenShot(String fileName) throws IOException{
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		String path = properties.getProperty("screenshot.folder");
	
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +fileName+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
