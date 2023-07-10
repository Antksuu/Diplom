package com.example.medicalreporting.service;

import com.example.medicalreporting.model.MedicalWaste;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MedicalWasteService {

    String saveMedWast(MedicalWaste medicalWaste, @RequestParam Integer cvartl,
                       @RequestParam Integer years, @RequestParam Integer waste_1, @RequestParam Integer waste_2, @RequestParam Integer waste_3,
                       @RequestParam Integer waste_4, @RequestParam Integer waste_5, @RequestParam Integer waste_6, @RequestParam Integer waste_7,
                       @RequestParam Integer waste_8, @RequestParam Integer waste_9, @RequestParam Integer waste_10, @RequestParam Integer waste_11,
                       @RequestParam Integer waste_12, @RequestParam Integer waste_13, @RequestParam Integer waste_14,
                       @RequestHeader Integer otchet_a_b, @RequestHeader Integer otchet_a);

    List<MedicalWaste> findAllMedWaste();

    List<MedicalWaste> findAllDateMedWaste(Integer years, Integer cvartl);

    String updateMedicWaste(MedicalWaste medicalWaste);
}
