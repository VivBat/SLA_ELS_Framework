package com.training.generics;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *   Class to click on an object
 */
public class setText{

	private WebDriver driver; 

	public setText(WebDriver driver){
		this.driver = driver; 
	}
	
	public void setKeys(WebElement webEle, String keysToSend){
			
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		
		ewait.until(ExpectedConditions.visibilityOf(webEle));
		
		webEle.sendKeys(keysToSend);
		
	}
		
}	
	

