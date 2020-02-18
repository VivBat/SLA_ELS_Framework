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


//POM file to login to the app for a user
public class login_AUT_POM {
	
	
	//declaring the variables	
	private WebDriver driver; 
	private ClickObject clickElement;
	private ScreenShot takeScreen;
	

	
	//declaring the constructor
	public login_AUT_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		clickElement = new ClickObject(driver);
		takeScreen = new ScreenShot(driver);
	}
	
	//locating login button
	@FindBy(xpath="//img[@src='../../assets/img/icons/rsz_corp-login.png']")
	private WebElement loginButton;
	
	//locating mockpass login button
	@FindBy(xpath="//div[@class='container visible-lg']/div/button[@id='loginModelbtn']")
	private WebElement mockLoginButton; 
	
	//login username select button
	@FindBy(xpath="//button[@id='dropdownMenuButton']")
	private WebElement loginUserNameButton;
	
	
	//method to click on login button
	public void clickingLoginButton() {
//		this.loginButton.click();
		clickElement.clickOnObect(this.loginButton);
	}
	
	//method to click in mockpass login button
	public void clickMockPassLoginBtn(){
//		this.mockLoginButton.click();
		clickElement.clickOnObect(this.mockLoginButton);
	}
	
	public void selectUserName(String username) {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();",this.loginUserNameButton);
//		this.loginUserNameButton.click();
		//selecting a username
		WebElement loginUser = driver.findElement(By.xpath("//a[contains(text(),'"+username+"')]"));
		js.executeScript("arguments[0].click();",loginUser);
//		loginUser.click();
		
	}

	
	//method to assert title
	public void assertTitleOfPage(String title) {
		assertEquals(driver.getTitle(), title);
		System.out.println("Asserted that the title of page is: "+ title);
	}
	
		
	//method to do all of the above in one go//
	public void loginByUser(String username) throws IOException {
		System.out.println("running for "+ username);
		assertTitleOfPage("SlaElsUi");
		clickingLoginButton(); 
		assertTitleOfPage("MockPass Login");
		clickMockPassLoginBtn();
		selectUserName(username);	
		assertTitleOfPage("SlaElsUi");
		takeScreen.captureScreenShot();
		
	}
	
}
	





