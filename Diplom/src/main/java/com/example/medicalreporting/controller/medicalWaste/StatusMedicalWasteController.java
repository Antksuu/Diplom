package com.example.medicalreporting.controller.medicalWaste;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.model.StatusMedicalWaste;
import com.example.medicalreporting.service.MedicalWasteService;
import com.example.medicalreporting.service.StatusMedicalWasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StatusMedicalWasteController {
    private static final Logger log = LoggerFactory.getLogger(StatusMedicalWasteController.class);
    @Autowired
    private StatusMedicalWasteService statusMedicalWasteService;
    @Autowired
    private MedicalWasteService medicalWasteService;


    public StatusMedicalWasteController(StatusMedicalWasteService statusMedicalWasteService) {
        this.statusMedicalWasteService = statusMedicalWasteService;
    }
    @GetMapping(value = "/update_status")
    public String getOtcx(Model model) {

        return "medical_waste_otchet";
    }
    @PostMapping("/update_status")
    public String addStatusMedOtx(Model model, @RequestParam Integer years, @RequestParam Integer cvartl, @Param("status") String status, @Param("comment_status") String comment_status) {
        String addStatus = statusMedicalWasteService.StatusUpdate(years, cvartl, status, comment_status);
        model.addAttribute("addStatus", addStatus);

        return "medical_waste_otchet";
    }

    @GetMapping("/status_medotx")
    public String tabStatus(Model model, MedicalWaste medicalWaste, StatusMedicalWaste statusMedicalWaste) {
        List<MedicalWaste> currentStatus = statusMedicalWasteService.findAllStatusMedWaste(medicalWaste, statusMedicalWaste);
        log.info("Найдены записи: {} ", currentStatus);
        model.addAttribute("currentStatus", currentStatus);

        return "medical_waste_examination";
    }

}
