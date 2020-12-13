package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TestCases.LoginTest_002;

public class ExcelReader {

	
	public static XSSFWorkbook wb = null;
	public static XSSFSheet sheet= null;
	public static FileInputStream fis=null;
	public static String url="./Configuration/ExcelReader.xlsx";
	
	
	
	public static  int  CountRow( int sheetIndex) throws IOException
	{

		 fis = new FileInputStream(url);
		 wb= new XSSFWorkbook(fis);
		 wb.close();
		 fis.close();
		return wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
		
	}
	public static  int  CountCell( int sheetIndex , int rowNum) throws IOException
	{

		 fis = new FileInputStream(url);
		 wb= new XSSFWorkbook(fis);
		 wb.close();
		 fis.close();
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getPhysicalNumberOfCells();
		
	}
	public static  Object ReadData( int sheetIndex , int rowNum , int cellNum) throws IOException
	{

		 fis = new FileInputStream(url);
		 wb= new XSSFWorkbook(fis);
		 wb.close();
		 fis.close();
		
		DataFormatter fm = new DataFormatter();
		return fm.formatCellValue(wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(cellNum));
	}
	
	
	
	
	
}
