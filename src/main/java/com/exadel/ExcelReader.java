package com.exadel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static com.exadel.MainClass.log;

public class ExcelReader {

    public List<CustomObject> readSheetToList(String sheetName, String pathExcel) {
        List<CustomObject> customObjects = new ArrayList<CustomObject>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(pathExcel);
        } catch (FileNotFoundException e) {
            log.error("File " + pathExcel + " not found.");
        }

        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            log.error("I/O Exception when try to create XSSFWorkbook instance.");
        }

        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (isRowSuitable(row))
                customObjects.add(readRowToObject(row));
        }
        if (fis != null){
            try {
                fis.close();
            } catch (IOException e) {
                log.error("Can not close input stream.");
            }
        }
        log.info("Collection created, " + customObjects.size() + " entities.");
        return customObjects;
    }

    private CustomObject readRowToObject(Row row){
        CustomObject customObject = new CustomObject();
        customObject.setDemographic(row.getCell(0).getStringCellValue());
        customObject.setMedium(row.getCell(1).getStringCellValue());
        customObject.setBreakValue(row.getCell(2).getStringCellValue());
        customObject.setReachPerc(row.getCell(3).getNumericCellValue());
        customObject.setPopulation(row.getCell(4).getNumericCellValue());
        return customObject;
    }

    private boolean isRowSuitable(Row row){
        Cell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        if (value.split(" ").length == 2)
            return true;
        else
            return false;
    }
}
