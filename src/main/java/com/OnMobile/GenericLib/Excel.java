package com.OnMobile.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	public static Logger logger = Logger.getLogger(Excel.class.getName());
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static Workbook wb;
	public static Sheet sheet;
	public static Row row;
	public static String Data;
	
	{
	PropertyConfigurator.configure("./resources/conf/log4j.properties");
	}
	
	public static String getExcelData(String SheetName, int rowNumber, int coloumNumber){
		try {
			prop.load(new FileInputStream("./resources/conf/test.properties"));
			logger.info("================Excel sheet load===================");
			 fis = new FileInputStream(new File(prop.getProperty("excelSheet")));
			 
		} catch (FileNotFoundException e) {
			logger.error("===============FileNotFoundException for Excel Sheet=============",e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("==========Input-Output Exception==========",e);
			e.printStackTrace();
		}
		
		try {
			logger.info("===============Find Excel Sheet=================");
			 wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			logger.error("EncryptedDocumentException while creating Excel Sheet .... ",e);
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			logger.error("InvalidFormatException while fetching data from Excel Sheet ...",e);
			
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("==========Input-Output Exception for Excel sheet==========",e);
			e.printStackTrace();
		}
		
		try{
		logger.info("================Fetch RowNumber and coloumNumber from Excel Sheet ================ ");
		sheet = wb.getSheet(SheetName);
		row =sheet.getRow(rowNumber);
		Data=row.getCell(coloumNumber).getStringCellValue();
		}catch(Exception e){
		logger.error("================Fetch RowNumber and coloumNumber from Excel Sheet ================", e);	
		}
		return Data;
		
	}

}
