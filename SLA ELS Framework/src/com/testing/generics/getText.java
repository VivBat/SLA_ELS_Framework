package com.testing.generics;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *   Class to get data from a field
 */
public class getText{

	private WebDriver driver; 

	public getText(WebDriver driver){
		this.driver = driver; 
	}
	
	public void getKeys(WebElement webEle){
			
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		
		ewait.until(ExpectedConditions.visibilityOf(webEle));
		
		webEle.getText();
		
	}
		
}	
	

