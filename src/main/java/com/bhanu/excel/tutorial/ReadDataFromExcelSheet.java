package com.bhanu.excel.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class ReadDataFromExcelSheet {

	public String[][] getExcelData(String excellocation, String sheetName) {
		try {
			String dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows
			int totalRow = sheet.getLastRowNum();
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow][totalColumn];
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				System.out.println(i);
				i++;
				Row row = rowIterator.next();
					// For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					int j = 0;
					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();
						if(cell.getStringCellValue().contains("User Name")){
							 break;
						}
						
						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							dataSets[i][j++] = cell.getStringCellValue();
							System.out.println(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							dataSets[i][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							dataSets[i][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							dataSets[i][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						}
						
					}
				
					System.out.println("");
			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  void updateResult(String excellocation, String sheetName, String testCaseName, String testStatus)
			throws IOException {

		try {
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(1).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(2).setCellValue(testStatus);
					file.close();
					System.out.println("resule updated");
					FileOutputStream outFile = new FileOutputStream(new File(excellocation));
					workbook.write(outFile);
					outFile.close();
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String excellocation = "/Users/bsingh5/git/excel-tutorial-with-dataDrivenFramework/demo.xlsx";
		String sheetName = "TestReport";
		ReadDataFromExcelSheet excel = new ReadDataFromExcelSheet();
//		String[][] data = excel.getExcelData(excellocation, sheetName);
//		System.out.println(data);
		excel.updateResult(excellocation, sheetName, "Login Test", "FAIL");
		excel.updateResult(excellocation, sheetName, "Registartion Test", "PASS");
		excel.updateResult(excellocation, sheetName, "Dashboard Test", "PASS");
	}
}
