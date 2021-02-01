package com.test.exercises.excelreadwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Exception {

		File input = new File("./../resources/ExcelData/DummyTestData.xlsx");

		FileInputStream fis = new FileInputStream(input);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = workbook.getSheet("Sheet1");

		XSSFRow row1 = sheet1.getRow(0);

		String cell00 = row1.getCell(0).getStringCellValue();
		String cell01 = row1.getCell(1).getStringCellValue();

		System.out.println("Data from Excel is : " + cell00 + " and " + cell01);
		
		fis.close();

		sheet1.getRow(0).getCell(2).setCellValue("OK");

		FileOutputStream fos = new FileOutputStream(input);
		
		workbook.write(fos);
		
		fos.close();

		workbook.close();
	}
}
