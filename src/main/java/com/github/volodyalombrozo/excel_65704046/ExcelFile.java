package com.github.volodyalombrozo.excel_65704046;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFile {

    private final List<Object[]> data;
    private final String filePath;

    public ExcelFile(final List<Object[]> data, final String filePath) {
        this.data = data;
        this.filePath = filePath;
    }

    public void export() {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet();
            fillSheet(sheet);
            workbook.write(new FileOutputStream(filePath));
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    private void fillSheet(final XSSFSheet sheet) {
        for (int i = 0; i < data.size(); i++) {
            XSSFRow excelRow = sheet.createRow(i);
            Object[] dbRow = data.get(i);
            fillRow(excelRow, dbRow);
        }
    }

    private void fillRow(final XSSFRow row, final Object[] dbRow) {
        for (int j = 0; j < dbRow.length; j++) {
            XSSFCell cell = row.createCell(j);
            cell.setCellValue(String.valueOf(dbRow[j]));
        }
    }
}
