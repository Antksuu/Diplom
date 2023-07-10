package com.example.medicalreporting.service;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.repository.MedicalWaste1Repository;
import com.example.medicalreporting.repository.MedicalWasteSumDtoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StatisticsMedicalWasteService {

    List<MedicalWasteSumDtoRepository> StatisticsMedicWa(Integer years, Integer waste_1, Integer waste_2, Integer waste_3,
                                                         Integer waste_4, Integer waste_5, Integer waste_6,
                                                         Integer waste_7,Integer otchet_a_b);

     List<MedicalWaste1Repository> statisticWaste1(@Param("years") Integer years, @Param("waste_1") Integer waste_1);
}
