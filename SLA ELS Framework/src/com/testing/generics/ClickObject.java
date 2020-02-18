package com.testing.generics;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *   Class to click on an object
 */
public class ClickObject{

	private WebDriver driver; 

	public ClickObject(WebDriver driver){
		this.driver = driver; 
	}
	
	public void clickOnObect(WebElement webEle){
			
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		
		ewait.until(ExpectedConditions.elementToBeClickable(webEle));
		webEle.click();	
		
	}
		
}	
	

