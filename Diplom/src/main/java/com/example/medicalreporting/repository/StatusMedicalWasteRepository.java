package com.example.medicalreporting.repository;

import com.example.medicalreporting.model.StatusMedicalWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusMedicalWasteRepository extends JpaRepository<StatusMedicalWaste, Long> {

}
