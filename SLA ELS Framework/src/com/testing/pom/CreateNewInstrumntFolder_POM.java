package com.testing.pom;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.generics.ClickObject;
import com.testing.generics.ScreenShot;
import com.testing.generics.hoverAction;


//POM file to login to the app for a user
public class CreateNewInstrumntFolder_POM {
	
	
	//declaring the variables	
	private WebDriver driver; 
	private ClickObject clickElement;
	private ScreenShot takeScreen;
	private hoverAction hover;

	
	//declaring the constructor
	public CreateNewInstrumntFolder_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		clickElement = new ClickObject(driver);
		takeScreen = new ScreenShot(driver);
		hover = new hoverAction(driver);
	}
	
	//locating e-lodgement button
	@FindBy(xpath="//a[contains(text(),'ABOUT STARS E-LODGMENT')]")
	private WebElement eLodgementButton;
	
	//locating'create new instrument folder' button
	@FindBy(xpath="//a[contains(text(),'CREATE NEW INSTRUMENT FOLDER LIBRARY')]")
	private WebElement createNewFolderButton; 
	
	
	//hover on e-lodgement button
	public void hoverOnLodgementButton() {
        hover.hoverOnElement(eLodgementButton);
		
	}
	
	//method to click on 'create new instrument folder' button
	public void clickCreateNewFolderButton(){
//		this.mockLoginButton.click();
		clickElement.clickOnObect(this.createNewFolderButton);
	}
	
	
	//method to assert title
	public void assertTitleOfPage(String title) {
		assertEquals(driver.getTitle(), title);
		System.out.println("Asserted that the title of page is: "+ title);
	}
	
		
	//method to do all of the above in one go//
	public void createNewInstrumentFolder() throws IOException {
		hoverOnLodgementButton();
		takeScreen.captureScreenShot();
		clickElement.clickOnObect(this.createNewFolderButton);
		takeScreen.captureScreenShot();
		
	}
	
}
	





