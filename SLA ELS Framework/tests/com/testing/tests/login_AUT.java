package com.testing.tests;
                 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
    
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.dataproviders.LoginUsers_Dataprovider;
import com.testing.generics.ScreenShot;
import com.testing.pom.CreateNewInstrumntFolder_POM;
import com.testing.pom.login_AUT_POM;
import com.testing.utility.DriverFactory;
import com.testing.utility.DriverNames;
import com.testing.utility.ExcelUtils;
import com.testing.utility.ReturnExcelData;
                
                
                
public class login_AUT {
	             
	static WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String AppURL;
	private static Properties properties;
	private login_AUT_POM logUser;
	private ReturnExcelData excelData;

	            
                
		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
		      	properties = new Properties();
			  	FileInputStream inStream = new FileInputStream("./resources/others.properties");
			  	properties.load(inStream);
		}	 	
			 	
		        
		@BeforeMethod
		public void setUp() throws Exception {
			    driver = DriverFactory.getDriver(DriverNames.CHROME);
			   
			    //For headless browser--not complete yet
//		  	 	driver = DriverFactory.getDriver(DriverNames.CHROME_HEADLESS); 
//		  	 	createFolder = new CreateNewInstrumntFolder_POM(driver);
	  		    
			    logUser = new login_AUT_POM(driver);
			    
		  	 	////////picking up URL to the server from the excel sheet/////////
		  	 	
		  	 	//new  object instance of ReturnExcelData() which will URLs data from excel
		  		excelData = new ReturnExcelData();
		  		//array to hold data returned by ReturnExcelData()
		  		Object[][] data = excelData.getExcelData("/ExcelWorkbooks/Automation_data.xlsx", "URLs");
		  		//checks if the column which tells if this is the URL is y or n. 		  		
				for(int i=0; i<data.length; i++) {
					//if the column is y, then that URL is set as the AppURL
					if(data[i][2].toString().equalsIgnoreCase("y")) {
						AppURL = data[i][1].toString();
//						System.out.println("URL is: "+ AppURL);
					}
				}
				//////////////////////////////////////////////////////////////////
				
				//opening the URL
		   		driver.get(AppURL);
		   	
            
		}        
		        
		        
		        
    	@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(2000);
			driver.quit();
		}		
				

		@Test(dataProvider="Login_Users", dataProviderClass = LoginUsers_Dataprovider.class)
		//Login_Users.Dataprovider picks the usernames from excel sheet
		//dataProviderClass is under com.training.dataproviders
		public void loginUser(String uname) throws IOException {
			//logging in using the data provided by the dataProvider. It provides usernames from excel sheet			
			logUser.loginByUser(uname);			
		
		}
		
		
	
    
}   
    