package com.test.exercises.excelreadwrite;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {

		File input = new File("./../resources/ExcelData/DummyTestData.xlsx");

		FileInputStream fis = new FileInputStream(input);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		ReadExcel.staticMethod(workbook);

		ReadExcel.dynamicMethod(workbook);

		ReadExcel.dynamicUsingIterator(workbook);

		workbook.close();
	}

	public static void staticMethod(XSSFWorkbook wb) {

		XSSFSheet sheet1 = wb.getSheet("Sheet1");

		XSSFRow row1 = sheet1.getRow(0);

		String cell00 = row1.getCell(0).getStringCellValue();
		String cell01 = row1.getCell(1).getStringCellValue();

		System.out.println("Data from Excel is : " + cell00 + " and " + cell01);
	}

	public static void dynamicMethod(XSSFWorkbook wb) {

		XSSFSheet sheet1 = wb.getSheet("Sheet1");

		int totalRows = sheet1.getLastRowNum();

		System.out.println("Total rows are : " + (totalRows + 1));

		for (int row = 0; row <= totalRows; row++) {

			String cellValue = sheet1.getRow(row).getCell(0).getStringCellValue();

			System.out.println("Data from excel is : " + cellValue);
		}
	}

	public static void dynamicUsingIterator(XSSFWorkbook wb) {

		XSSFSheet sheet1 = wb.getSheet("Sheet1");

		Iterator<Row> rowItr = sheet1.iterator();

		while (rowItr.hasNext()) {
			Row row = rowItr.next();

			Iterator<Cell> cellItr = row.cellIterator();

			while (cellItr.hasNext()) {
				Cell cell = cellItr.next();
				System.out.print("Data for Row " + (row.getRowNum() + 1) + " and Column " + cell.getColumnIndex() + " "
						+ cell.getStringCellValue() + " ");
			}
			System.out.println();
		}
	}

	public static Object[][] getData() {

		Object[][] data = new Object[][] {};

		try {
			File input = new File("./../resources/ExcelData/DummyLoginData.xlsx");

			FileInputStream fis = new FileInputStream(input);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet1 = workbook.getSheet("Sheet1");

			// Initialize array with number of rows in sheet
			data = new Object[sheet1.getLastRowNum() + 1][];

			Iterator<Row> rowItr = sheet1.iterator();

			while (rowItr.hasNext()) {
				Row row = rowItr.next();

				// For each row, initialize number of columns of 2-D array
				data[row.getRowNum()] = new Object[row.getLastCellNum()];

				Iterator<Cell> cellItr = row.cellIterator();

				while (cellItr.hasNext()) {
					Cell cell = cellItr.next();

					data[row.getRowNum()][cell.getColumnIndex()] = cell.getStringCellValue();
				}
			}

			workbook.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
}