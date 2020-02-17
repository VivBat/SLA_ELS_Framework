package com.training.generics;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *   Class to handle exceptions
 */
public class ExceptionHandler{

	private WebDriver driver; 

	public ExceptionHandler(WebDriver driver){
		this.driver = driver; 
	}
	
	private void handleException(WebElement webEle){
			
		try {
			driver.findElement(webEle);
		}
		
	}
		
}	
	

