package com.testing.generics;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *   Class to click on an object ONLY for a SELECT
 */
public class SelectDropdown{

	private WebDriver driver; 

	public SelectDropdown(WebDriver driver){
		this.driver = driver; 
	}
	
	private void SelectObect(WebElement webEle, String itemToSelect){
			
		Select dropdown = new Select(webEle);  
		
        WebDriverWait ewait = new WebDriverWait(driver, 10);
		
		ewait.until(ExpectedConditions.elementToBeSelected(webEle));
				
		List<WebElement> e = dropdown.getOptions();
		
		 //iterate through the values and print it
//        for(int l = 0; l < e.size(); l++)
//        {
//            System.out.println(e.get(l).getText());
//        }
		
        dropdown.selectByVisibleText(itemToSelect);
	}
		
}	
	

