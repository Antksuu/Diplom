package com.example.medicalreporting.generator;

import com.example.medicalreporting.model.MedicalWaste;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.List;

/**
 * Класс для выгрузки отчета в Excel, а также создания необходимого шаблона
 * Created by Antonova Ksenia.
 */
public class ExcelGeneratorMedicalWaste {

    private List<MedicalWaste> medicalWastesList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGeneratorMedicalWaste(List<MedicalWaste> medicalWastesList) {
        this.medicalWastesList = medicalWastesList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("MedicalWaste");
        int rowCountHeader = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        style.setFont(font);

        Row row = sheet.createRow(rowCountHeader++);
        int columnCountHeader = 1;
        createCell(row, columnCountHeader++, "Кол-во (кг)", style);
        createCell(row, columnCountHeader++, "Перевязочный материал", style);
        createCell(row, columnCountHeader++, "Пищевые отходы", style);
        createCell(row, columnCountHeader++, "Полимерные отходы", style);
        createCell(row, columnCountHeader++, "Метал", style);
        createCell(row, columnCountHeader++, "Паталогоанатомические отходы", style);
        createCell(row, columnCountHeader++, "Лабораторные отходы", style);
        createCell(row, columnCountHeader++, "Прочее", style);
        createCell(row, columnCountHeader++, "Всего", style);


    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }

    private void write() {
        int rowCount = 2;
        int rowCount2 = 3;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        CellStyle style1 = workbook.createCellStyle();
        XSSFFont font1 = workbook.createFont();
        font1.setBold(true);
        font1.setFontHeight(14);
        style1.setFont(font1);
        for (MedicalWaste record : medicalWastesList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 1;
            createCell(row, columnCount++, "A/B", style1);
            createCell(row, columnCount++, record.getWaste_1(), style);
            createCell(row, columnCount++, record.getWaste_2(), style);
            createCell(row, columnCount++, record.getWaste_3(), style);
            createCell(row, columnCount++, record.getWaste_4(), style);
            createCell(row, columnCount++, record.getWaste_5(), style);
            createCell(row, columnCount++, record.getWaste_6(), style);
            createCell(row, columnCount++, record.getWaste_7(), style);
            createCell(row, columnCount++, record.getOtchet_a_b(), style);

            Row row1 = sheet.createRow(rowCount2++);
            int columnCount1 = 1;
            createCell(row1, columnCount1++, "A", style1);
            createCell(row1, columnCount1++, record.getWaste_8(), style);
            createCell(row1, columnCount1++, record.getWaste_9(), style);
            createCell(row1, columnCount1++, record.getWaste_10(), style);
            createCell(row1, columnCount1++, record.getWaste_11(), style);
            createCell(row1, columnCount1++, record.getWaste_12(), style);
            createCell(row1, columnCount1++, record.getWaste_13(), style);
            createCell(row1, columnCount1++, record.getWaste_14(), style);
            createCell(row1, columnCount1++, record.getOtchet_a(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
