package com.testing.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * This class will load the given driver, and follows factory pattern  
 */
public class DriverFactory {
	// it only a reference 
	private static WebDriver driver; 
	
	public static WebDriver getDriver(String driverName){

		if(driverName.equals(DriverNames.CHROME)){
			System.setProperty(Driver.CHROME, Driver.CHROME_PATH);
			driver = new ChromeDriver();
		
			
		}else if(driverName.equals(DriverNames.FIREFOX)){
			System.setProperty(Driver.FIREFOX, Driver.FIREFOX_PATH);
			driver = new FirefoxDriver();
			
		}else if(driverName.equals("IE")){
			// TODO 
		}else if(driverName.equals(DriverNames.CHROME_HEADLESS)){
			System.setProperty(Driver.CHROME, Driver.CHROME_PATH);
			 ChromeOptions options = new ChromeOptions();
             options.addArguments("--headless");
             WebDriver driver = new ChromeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}