package com.example.medicalreporting.controller.medicalWaste;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.repository.MedicalWaste1Repository;
import com.example.medicalreporting.repository.MedicalWasteSumDtoRepository;
import com.example.medicalreporting.service.StatisticsMedicalWasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StatisticsMedWasteController {
    private static final Logger log = LoggerFactory.getLogger(StatisticsMedWasteController.class);

    @Autowired
    private StatisticsMedicalWasteService statisticsMedicalWasteService;

    @GetMapping("/statistic_medotx")
    public String tabStatus(Model model,Integer years, Integer waste_1, Integer waste_2, Integer waste_3,
                            Integer waste_4, Integer waste_5, Integer waste_6,
                            Integer waste_7,Integer otchet_a_b) {
        List<MedicalWasteSumDtoRepository>  statistMedWest = statisticsMedicalWasteService.StatisticsMedicWa(years,waste_1,waste_2,waste_3,waste_4,waste_5,waste_6,waste_7,otchet_a_b);
        log.info("statistMedWest: {} ", statistMedWest);
        model.addAttribute("statistMedWest", statistMedWest);

        return "medical_waste_statistics";
    }

}
