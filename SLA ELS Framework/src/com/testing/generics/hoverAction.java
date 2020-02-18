package com.testing.generics;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *   Class to hover on an element
 */
public class hoverAction{

	private WebDriver driver; 

	public hoverAction(WebDriver driver){
		this.driver = driver; 
	}
	
	public void hoverOnElement(WebElement webEle){
			
		WebDriverWait ewait = new WebDriverWait(driver, 10);	
		ewait.until(ExpectedConditions.visibilityOf(webEle));
		
		Actions action = new Actions(driver);
		action.moveToElement(webEle).perform();
		
	}
		
}	
	

