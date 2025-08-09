package com.cab.cucumber.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static String[] data = new String[10];
	static String filePath = "";
	static FileInputStream file;
	static FileOutputStream fileOut;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	public static String[] excelReader(String fileName, String sheetName, String getRow) throws Exception {
		filePath = new File(fileName).getAbsolutePath();
		file = new FileInputStream(filePath);
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(Integer.parseInt(getRow));
		for(int i=0; i<10; i++) {
			cell = row.getCell(i);
			if(cell != null) {
				DataFormatter formatter = new DataFormatter();
				data[i] = formatter.formatCellValue(cell);
			} else {
				data[i] = "";
			}
		}
		return data;
	}
}
