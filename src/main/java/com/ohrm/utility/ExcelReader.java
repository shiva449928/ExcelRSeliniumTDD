package com.ohrm.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader  {
	public static Object[][] getData(String filepath, String sheetname)  {
		
		XSSFWorkbook wb = null;
				try {
					new XSSFWorkbook(filepath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		XSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowcount][colcount];
		for (int row = 0; row < rowcount; row++) {
			for (int col = 0; col < colcount; col++) {
				data[row][col]= sheet.getRow(row).getCell(col).getStringCellValue();
			}
		}
		return data;
	}
}
