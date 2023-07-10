package com.example.medicalreporting.service.impl;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.model.StatusMedicalWaste;
import com.example.medicalreporting.repository.MedicalWasteRepository;
import com.example.medicalreporting.repository.StatusMedicalWasteRepository;
import com.example.medicalreporting.service.StatusMedicalWasteService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatusMedicalWasteServiceImpl implements StatusMedicalWasteService {
    private static final Logger log = LoggerFactory.getLogger(StatusMedicalWasteServiceImpl.class);

    @Autowired
    private StatusMedicalWasteRepository statusMedicalWasteRepository;

    @Autowired
    private MedicalWasteRepository medicalWasteRepository;

    public StatusMedicalWasteServiceImpl(StatusMedicalWasteRepository statusMedicalWasteRepository) {
        this.statusMedicalWasteRepository = statusMedicalWasteRepository;
    }

    public List<MedicalWaste> findAllStatusMedWaste(MedicalWaste medicalWaste, StatusMedicalWaste statusMedicalWaste) {

        List<MedicalWaste> all = medicalWasteRepository.findAll();
        log.info("Найдены все записи: {} ", all);
        return all;
    }

    @Transactional
    public String StatusUpdate(@Param("years") Integer years, @Param("cvartl") Integer cvartl, @Param("status") String status, @Param("comment_status") String comment_status) {
        medicalWasteRepository.update(years, cvartl, status, comment_status);
        log.info("Найден год: {} ", years);
        log.info("Найден квартал: {} ", cvartl);
        log.info("Обновлен статус: {} ", status);
        log.info("Обновлен комментарий: {} ", comment_status);

        return "update";
    }
}
