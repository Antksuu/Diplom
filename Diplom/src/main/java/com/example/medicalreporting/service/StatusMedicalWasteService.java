package com.example.medicalreporting.service;

import com.example.medicalreporting.model.MedicalWaste;
import com.example.medicalreporting.model.StatusMedicalWaste;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusMedicalWasteService {

    List<MedicalWaste> findAllStatusMedWaste(MedicalWaste medicalWaste, StatusMedicalWaste statusMedicalWaste);

    String StatusUpdate(@Param("years") Integer years, @Param("cvartl") Integer cvartl,
                        @Param("status") String status, @Param("comment_status") String comment_status);
}


