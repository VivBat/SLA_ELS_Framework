package com.testing.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//class returns all the data from a specified sheet of a specified data as a 2D array
public class ReturnExcelData {
	
	static XSSFWorkbook workbook;
	static String projectPath;
    static XSSFSheet sheet;
	static int rowCount;
	static int colCount;
	static ExcelUtils excel;
	

//	public static void main(String[] args) throws IOException {
    public  Object[][] getExcelData(String filePath, String sheetName) throws IOException {	

//		String filePath ="/ExcelWorkbooks/Automation_data.xlsx" ;
//		String sheetName =  "URLs";
		
     	//to get the project location so that we dont have to hardcode filepath
	    projectPath = System.getProperty("user.dir");
	    
	    //workbook at location: projectPath + filePath
	    workbook = new XSSFWorkbook(projectPath + filePath);
		
	    //the sheet that contains our test data 
	    sheet = workbook.getSheet(sheetName);
	    
	    excel =new ExcelUtils(filePath, sheetName);
    	
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
//		System.out.println("rowcount= "+rowCount);
//		System.out.println("colcount= "+colCount);
		
        //an object that will contain our data from excel sheet
		Object[][] data = new Object[rowCount-1][colCount];
		
		//iterating through rows and columns in the excel that we want
		for(int i = 0; i<rowCount-1; i++) {
			for(int j = 0; j<colCount; j++) {
				data[i][j] = excel.getCellDataString(i+1, j);
//				System.out.println("i="+i+"   j= " +j+ "-----"+data[i][j]);
			}
		}

		return data;
	}


}
