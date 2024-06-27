package com.maven.testNG;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxUtility {

	public static List<Object[]> readUserCredentials(String filePath) {
        List<Object[]> userCredentials = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header row
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell usernameCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);
                String username = getStringValue(usernameCell);
                String password = getStringValue(passwordCell);
                userCredentials.add(new Object[]{username, password});
            }
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
        return userCredentials;
    }

    private static String getStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
