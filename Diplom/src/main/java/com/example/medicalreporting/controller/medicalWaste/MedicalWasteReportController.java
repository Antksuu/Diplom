package com.example.medicalreporting.controller.medicalWaste;

import com.example.medicalreporting.generator.ExcelGeneratorMedicalWaste;
import com.example.medicalreporting.generator.ExcelPOIHelper;
import com.example.medicalreporting.generator.WordGeneratorMedicalWaste;
import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.repository.MedicalWasteRepository;
import com.example.medicalreporting.service.MedicalWasteService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE;

/**
 * Класс контроллер включает в себя метод для добавление данных отчета в бд
 * Метод для выгрузки отчета в Excel
 * Метод для выгрузки отчета в Word
 * Created by Antonova Ksenia.
 */
@Controller
public class MedicalWasteReportController {
    private static final Logger log = LoggerFactory.getLogger(MedicalWasteReportController.class);
    @Autowired
    private MedicalWasteService medicalWasteService;

    private MedicalWasteRepository medicalWasteRepository;
    private ExcelPOIHelper excelPOIHelper;
    private String fileLocation;


    @GetMapping(value = "/add_med_ot")
    public String allMedicalOtx(Model model) {
        model.addAttribute("addMO", new MedicalWaste());
        return "medical_waste_add";
    }

    @PostMapping(value = "/add_med_ot")
    public String addMedOtx(@ModelAttribute("addMO") @Valid MedicalWaste medicalWaste, @RequestParam Integer cvartl,
                            @RequestParam Integer years, @RequestParam Integer waste_1, @RequestParam Integer waste_2, @RequestParam Integer waste_3,
                            @RequestParam Integer waste_4, @RequestParam Integer waste_5, @RequestParam Integer waste_6, @RequestParam Integer waste_7,
                            @RequestParam Integer waste_8, @RequestParam Integer waste_9, @RequestParam Integer waste_10, @RequestParam Integer waste_11,
                            @RequestParam Integer waste_12, @RequestParam Integer waste_13, @RequestParam Integer waste_14,
                            @RequestParam Integer otchet_a_b, @RequestParam Integer otchet_a) {
        medicalWasteService.saveMedWast(medicalWaste, cvartl, years, waste_1, waste_2, waste_3, waste_4, waste_5, waste_6, waste_7, waste_8, waste_9, waste_10, waste_11, waste_12, waste_13, waste_14, otchet_a_b, otchet_a);
        return "medical_waste_add";

    }

    @GetMapping(value = "/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response, @RequestParam Integer years, @RequestParam Integer cvartl) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=MedicalWaste" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<MedicalWaste> listOfMedicalWaste = medicalWasteService.findAllDateMedWaste(years, cvartl);
        ExcelGeneratorMedicalWaste generator = new ExcelGeneratorMedicalWaste(listOfMedicalWaste);
        generator.generateExcelFile(response);

    }

    @GetMapping(value = "/export-to-word", produces = APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> word(@RequestParam Integer years, @RequestParam Integer cvartl)
            throws IOException, InvalidFormatException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        List<MedicalWaste> listOfMedicalWaste = medicalWasteService.findAllDateMedWaste(years, cvartl);

        ByteArrayInputStream bis = WordGeneratorMedicalWaste.generateWord(listOfMedicalWaste);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=MedicalWaste" + currentDateTime + ".docx")
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/view-report")
    public String view(Model model, @RequestParam Integer years, @RequestParam Integer cvartl) {
        List<MedicalWaste> viewReport = medicalWasteService.findAllDateMedWaste(years, cvartl);
        model.addAttribute("viewReport", viewReport);
        return "view";
    }

    @GetMapping(value = "/medic_update")
    public String viewUpdateGet(Model model, @RequestParam Integer cvartl,
                                  @RequestParam Integer years) {
        List<MedicalWaste> viewUp = medicalWasteService.findAllDateMedWaste(years, cvartl);
        model.addAttribute("viewUp", viewUp);
        log.info("Найдены записи: {} ", cvartl);
        return "med_waste_update";
    }

    @PostMapping(value = "/medic_update/put")
    public String viewUpdate(Model model, MedicalWaste medicalWaste) {
        String updateMedWaste = medicalWasteService.updateMedicWaste(medicalWaste);
        log.info("updateMedWaste: {} ", updateMedWaste);
        model.addAttribute("updateMedWaste", updateMedWaste);
        return "medical_waste_examination";
    }

}
