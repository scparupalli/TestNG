package com.maven.testNG.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	//static Logger mylog = LogManager.getLogger(ExcelUtils.class);

	// Method to read data from Excel file
	public static String readDataFromXl(String filePath, String sheetname, int rowIndex, int cellIndex)
			throws IOException {
		//mylog.info("started to read single data from "+ filePath);
		FileInputStream file = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetname); // Assuming data is in the first sheet
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();

	}

	// Method to read data from Excel file and return as a List of Lists
	public static List<List<String>> readAllDataFromXl(String filePath, String sheetName) {
		List<List<String>> allData = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowit=sheet.rowIterator();
			
			while(rowit.hasNext()) {
				List<String> rowDataList = new ArrayList<>();
				Row row=rowit.next();
				Iterator<Cell> cellit= row.cellIterator();
				while(cellit.hasNext()) {
					Cell cell=cellit.next();
					rowDataList.add(cell.toString());
				
				}
				allData.add(rowDataList);
			}
			

			workbook.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allData;
	}
	
	public static Object[][] readAllDataFromXlToArray(String filePath, String sheetName) {
		Object[][] data =null;
		
			return data;
	}

	// Method to write data to Excel file
	public static void writeExcelFile(String filePath, Object[][] data) {
		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Sheet1"); // Create a sheet

			int rowCount = 0;
			for (Object[] rowData : data) {
				Row row = sheet.createRow(rowCount++);
				int columnCount = 0;
				for (Object field : rowData) {
					Cell cell = row.createCell(columnCount++);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					} else if (field instanceof Double) {
						cell.setCellValue((Double) field);
					} // Add more conditions as needed for other data types
				}
			}

			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			workbook.write(fileOutputStream);

			workbook.close();
			fileOutputStream.close();

			System.out.println("Excel file has been written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
