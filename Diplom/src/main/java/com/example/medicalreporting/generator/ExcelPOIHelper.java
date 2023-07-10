package com.example.medicalreporting.generator;

import com.example.medicalreporting.model.MedicalWaste;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static java.sql.Types.NUMERIC;

/**
 * Класс для загрузки файла и импорта данных на форму html
 * Created by Antonova Ksenia.
 */
public class ExcelPOIHelper {


    public List<MedicalWaste> readExcelFile(String fileName) {
        List<MedicalWaste> result = new ArrayList<>();
        try (InputStream fileInputStream = new FileInputStream(fileName)) {
            // Read InputStream into Workbook
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            // Read the first Sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Get row Iterator
            Iterator<Row> rowIterator = sheet.rowIterator();

            // Skip the first row because it is the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            // Read all data rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Get cell Iterator
                Iterator<Cell> cellIterator = row.cellIterator();
                MedicalWaste medicalWaste = new MedicalWaste();
                // Read cell data
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {

                        case NUMERIC:
                            medicalWaste.setCvartl(cell.getColumnIndex());
                            medicalWaste.setYears(cell.getColumnIndex());
                            medicalWaste.setWaste_1(cell.getColumnIndex());
                            break;
                    }
                }
                result.add(medicalWaste);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
