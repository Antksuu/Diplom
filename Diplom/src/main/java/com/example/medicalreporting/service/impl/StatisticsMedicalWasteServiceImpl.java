package com.example.medicalreporting.service.impl;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.repository.MedicalWaste1Repository;
import com.example.medicalreporting.repository.MedicalWasteRepository;
import com.example.medicalreporting.service.StatisticsMedicalWasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.medicalreporting.repository.MedicalWasteSumDtoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StatisticsMedicalWasteServiceImpl implements StatisticsMedicalWasteService {
    private static final Logger log = LoggerFactory.getLogger(StatisticsMedicalWasteServiceImpl.class);
    @Autowired
    private MedicalWasteRepository medicalWasteRepository;

    public List<MedicalWasteSumDtoRepository> StatisticsMedicWa(Integer years, Integer waste_1, Integer waste_2, Integer waste_3,
                                                                Integer waste_4, Integer waste_5, Integer waste_6,
                                                                Integer waste_7, Integer otchet_a_b) {

        List<MedicalWasteSumDtoRepository> allStatistics = medicalWasteRepository.findAllStatistics(years, waste_1, waste_2, waste_3, waste_4, waste_5, waste_6, waste_7, otchet_a_b);
        log.info("years: {} ", years);
        log.info("waste_1: {} ", waste_1);
        log.info("allStatistics: {} ", allStatistics);
        return allStatistics;
    }

    public List<MedicalWaste1Repository> statisticWaste1(@Param("years") Integer years, @Param("waste_1") Integer waste_1) {

        List<MedicalWaste1Repository> allStatistics = medicalWasteRepository.findWaste1(years, waste_1);
        log.info("years: {} ", years);
        log.info("waste_1: {} ", waste_1);
        log.info("allStatistics: {} ", allStatistics);
        return allStatistics;
    }


}
