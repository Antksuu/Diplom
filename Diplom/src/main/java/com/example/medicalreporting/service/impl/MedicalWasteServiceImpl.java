package com.example.medicalreporting.service.impl;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.model.StatusMedicalWaste;
import com.example.medicalreporting.repository.MedicalWasteRepository;
import com.example.medicalreporting.repository.StatusMedicalWasteRepository;
import com.example.medicalreporting.service.MedicalWasteService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MedicalWasteServiceImpl implements MedicalWasteService {
    private static final Logger log = LoggerFactory.getLogger(MedicalWasteServiceImpl.class);
    @Autowired
    private MedicalWasteRepository medicalWasteRepository;
    @Autowired
    private StatusMedicalWasteRepository statusMedicalWasteRepository;

    public MedicalWasteServiceImpl(MedicalWasteRepository medicalWasteRepository) {
        this.medicalWasteRepository = medicalWasteRepository;
    }

    public List<MedicalWaste> findAllMedWaste() {
        return medicalWasteRepository.findAll();
    }

    public List<MedicalWaste> findAllDateMedWaste(Integer years, Integer cvartl) {
        List<MedicalWaste> allDateMed = medicalWasteRepository.findAllByYears(years, cvartl);
        log.info("Найдены записи: {} ", allDateMed);
        return allDateMed;
    }

    public String saveMedWast(MedicalWaste medicalWaste, @RequestParam Integer cvartl,
                              @RequestParam Integer years, @RequestParam Integer waste_1, @RequestParam Integer waste_2, @RequestParam Integer waste_3,
                              @RequestParam Integer waste_4, @RequestParam Integer waste_5, @RequestParam Integer waste_6, @RequestParam Integer waste_7,
                              @RequestParam Integer waste_8, @RequestParam Integer waste_9, @RequestParam Integer waste_10, @RequestParam Integer waste_11,
                              @RequestParam Integer waste_12, @RequestParam Integer waste_13, @RequestParam Integer waste_14,
                              @RequestHeader Integer otchet_a_b, @RequestHeader Integer otchet_a) {
        medicalWaste.setCvartl(cvartl);
        medicalWaste.setYears(years);
        medicalWaste.setWaste_1(waste_1);
        medicalWaste.setWaste_2(waste_2);
        medicalWaste.setWaste_3(waste_3);
        medicalWaste.setWaste_4(waste_4);
        medicalWaste.setWaste_5(waste_5);
        medicalWaste.setWaste_6(waste_6);
        medicalWaste.setWaste_7(waste_7);
        medicalWaste.setWaste_8(waste_8);
        medicalWaste.setWaste_9(waste_9);
        medicalWaste.setWaste_10(waste_10);
        medicalWaste.setWaste_11(waste_11);
        medicalWaste.setWaste_12(waste_12);
        medicalWaste.setWaste_13(waste_13);
        medicalWaste.setWaste_14(waste_14);
        medicalWaste.setOtchet_a_b(otchet_a_b);
        medicalWaste.setOtchet_a(otchet_a);

        StatusMedicalWaste statusMedicalWaste_id = new StatusMedicalWaste("В обработке", "");
        log.info("Создать запись: {} ", statusMedicalWaste_id);
        StatusMedicalWaste statusMedicalWaste_save = statusMedicalWasteRepository.save(statusMedicalWaste_id);
        log.info("Сохранить запись в таблицу Статус: {} ", statusMedicalWaste_save);
        medicalWaste.setStatusMedicalWastes(statusMedicalWaste_save);
        log.info("Сохранить id таблицы статус в таблицу медицинские отходы: {} ", statusMedicalWaste_save);

        medicalWasteRepository.save(medicalWaste);
        return "Saved";
    }

    @Transactional
    public String updateMedicWaste(MedicalWaste medicalWaste) {
        medicalWasteRepository.findAllByYearsCvartal(medicalWaste.getCvartl(), medicalWaste.getYears(),
                medicalWaste.getWaste_1(), medicalWaste.getWaste_2(), medicalWaste.getWaste_3(),
                medicalWaste.getWaste_4(), medicalWaste.getWaste_5(), medicalWaste.getWaste_6(), medicalWaste.getWaste_7(),
                medicalWaste.getWaste_8(), medicalWaste.getWaste_9(), medicalWaste.getWaste_10(), medicalWaste.getWaste_11(),
                medicalWaste.getWaste_12(), medicalWaste.getWaste_13(), medicalWaste.getWaste_14(),
                medicalWaste.getOtchet_a_b(), medicalWaste.getOtchet_a());
        return "update";
    }

}
