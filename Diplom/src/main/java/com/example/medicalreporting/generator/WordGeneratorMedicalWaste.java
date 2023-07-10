package com.example.medicalreporting.generator;

import com.example.medicalreporting.model.MedicalWaste;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

/**
 * Класс для выгрузки отчета в Word, а также создания необходимого шаблона
 * Created by Antonova Ksenia.
 */
public class WordGeneratorMedicalWaste {
    private static final Logger log = LoggerFactory.getLogger(WordGeneratorMedicalWaste.class);

    public static ByteArrayInputStream generateWord(List<MedicalWaste> medicalWasteList)
            throws FileNotFoundException, IOException,
            InvalidFormatException {

        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFParagraph p3 = doc.createParagraph();
            XWPFParagraph p4 = doc.createParagraph();
            XWPFParagraph p5 = doc.createParagraph();
            p3.setAlignment(ParagraphAlignment.CENTER);
            p4.setAlignment(ParagraphAlignment.CENTER);
            p5.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r3 = p3.createRun();
            XWPFRun r4 = p4.createRun();
            XWPFRun r5 = p5.createRun();
            r3.setFontSize(14);
            r4.setFontSize(14);
            r5.setFontSize(14);
            r3.setText("Отчет ");
            r4.setText("по медицинским отходам за " + medicalWasteList.get(0).getCvartl() + " квартал " + medicalWasteList.get(0).getYears());
            r5.setText("Девицкое ООВП");
            r3.setFontFamily("Times New Roman");
            r4.setFontFamily("Times New Roman");
            r5.setFontFamily("Times New Roman");
            r5.addBreak();
            r5.addBreak();


            XWPFTable table = doc.createTable();
            // Creating first Row
            XWPFTableRow row1 = table.getRow(0);

            row1.getCell(0).setText("Кол-во (кг)");
            row1.addNewTableCell().setText("Перевязочный материал");
            row1.addNewTableCell().setText("Пищевые отходы");
            row1.addNewTableCell().setText("Полимерные отходы");
            row1.addNewTableCell().setText("Метал");
            row1.addNewTableCell().setText("Паталогоанатомические отходы");
            row1.addNewTableCell().setText("Лабораторные отходы");
            row1.addNewTableCell().setText("Прочее");
            row1.addNewTableCell().setText("Всего");
            for (MedicalWaste medicalWaste1 : medicalWasteList) {
                // Creating second Row
                XWPFTableRow row2 = table.createRow();
                row2.getCell(0).setText("A/B");
                row2.getCell(1).setText(String.valueOf(medicalWaste1.getWaste_1()));
                row2.getCell(2).setText(String.valueOf(medicalWaste1.getWaste_2()));
                row2.getCell(3).setText(String.valueOf(medicalWaste1.getWaste_3()));
                row2.getCell(4).setText(String.valueOf(medicalWaste1.getWaste_4()));
                row2.getCell(5).setText(String.valueOf(medicalWaste1.getWaste_5()));
                row2.getCell(6).setText(String.valueOf(medicalWaste1.getWaste_6()));
                row2.getCell(7).setText(String.valueOf(medicalWaste1.getWaste_7()));
                row2.getCell(8).setText(String.valueOf(medicalWaste1.getOtchet_a_b()));

                for (MedicalWaste medicalWaste2 : medicalWasteList) {
                    XWPFTableRow row3 = table.createRow();
                    row3.getCell(0).setText("A");
                    row3.getCell(1).setText(String.valueOf(medicalWaste2.getWaste_8()));
                    row3.getCell(2).setText(String.valueOf(medicalWaste2.getWaste_9()));
                    row3.getCell(3).setText(String.valueOf(medicalWaste2.getWaste_10()));
                    row3.getCell(4).setText(String.valueOf(medicalWaste2.getWaste_11()));
                    row3.getCell(5).setText(String.valueOf(medicalWaste2.getWaste_12()));
                    row3.getCell(6).setText(String.valueOf(medicalWaste2.getWaste_13()));
                    row3.getCell(7).setText(String.valueOf(medicalWaste2.getWaste_14()));
                    row3.getCell(8).setText(String.valueOf(medicalWaste2.getOtchet_a()));
                }


            }

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            doc.write(b);
            return new ByteArrayInputStream(b.toByteArray());
        }

    }
}
