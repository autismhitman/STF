package com.ui.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	private static XSSFWorkbook wb;
	private static XSSFSheet sh;
	
	public ExcelUtil(String filePath, String sheetName) {
		File file = new File(filePath);
		try {
			wb = new XSSFWorkbook(file);
			sh= wb.getSheet(sheetName);
		} catch (InvalidFormatException e) {
		 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	public int getCellCount() {
		
		return sh.getRow(0).getLastCellNum();
	}
	
	public String readData(int row, int col) {
		
		return sh.getRow(row).getCell(col).getStringCellValue();
	}
}
