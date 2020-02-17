package com.training.dataproviders;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.training.utility.ExcelUtils;

//dataProvider for login_AUT testcase
public class LoginUsers_Dataprovider {

	    //declaring an XSSFSheet variable to store sheet in
		static XSSFSheet sheet;
		
		//declaring an XSSFWorkbook variable to store workbook sheet in
		static XSSFWorkbook workbook;
		
		//variable which will be used for an instance of ExcelUtils class
		static ExcelUtils excel;
		
		//the excel file path within the project folder and the sheetname that contains the testdata
		static private String filePath = "/ExcelWorkbooks/Automation_data.xlsx";
	    static private String sheetName = "Users";
	    
		//the data provider with name Login_Dataproviders. used in login_AUT testcase by giving the same name
		@DataProvider(name="Login_Users")		
//		public static void main(String[] args) throws IOException {
		public  Object[][] getUserData() throws IOException {
			
			//to get the project location so that we dont have to hardcode filepath
			//this gives, in our case: projectPath = C:\Users\VivekPunia\git\UniformSeleniumProject\Selenium-Automation-Elearning-Framework-TestNG
			String projectPath = System.getProperty("user.dir");
		
			//workbook at location: projectPath + /ExcelWorkbooks/Uniform_Test Cases_Complex.xlsx , which is the location of our excel file
			workbook = new XSSFWorkbook(projectPath + filePath);
			
			//the sheet that contains our test data is names sheetName = "TestData"
			sheet = workbook.getSheet(sheetName);
					
			//creating an instance of ExcelUtils. This class contains the general excel utility functions
			//like getting rowCount, getting cell data etc...
			excel =new ExcelUtils(filePath, sheetName);
			

			int rowCount = excel.getRowCount();
			int colCount = excel.getColCount();
			
			System.out.println("rowcount= "+rowCount);
			System.out.println("colcount= "+colCount);
			
	        //an object that will contain our data from excel sheet
			Object[][] userData = new Object[rowCount-1][colCount];
			
			//iterating through rows and columns in the excel that we want
			for(int i = 0; i<rowCount-1; i++) {
				for(int j = 0; j<colCount; j++) {
					userData[i][j] = excel.getCellDataString(i+1, j);
					System.out.println("i="+i+"   j= " +j+ "-----"+userData[i][j]);
				}
			}

			return userData;
		}

	}
