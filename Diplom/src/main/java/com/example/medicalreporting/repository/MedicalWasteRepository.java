package com.example.medicalreporting.repository;

import com.example.medicalreporting.model.MedicalWaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface MedicalWasteRepository extends JpaRepository<MedicalWaste, Long> {

    @Query("select b from MedicalWaste b where b.years = :years and b.cvartl = :cvartl")
    List<MedicalWaste> findAllByYears(@Param("years") Integer years, @Param("cvartl") Integer cvartl);

    @Modifying
    @Query("UPDATE StatusMedicalWaste " +
            "SET status = :status , comment_status = :comment_status " +
            "WHERE id = (SELECT statusMedicalWastes " +
            "FROM MedicalWaste where years = :years and cvartl = :cvartl)")
    void update(@Param("years") Integer years, @Param("cvartl") Integer cvartl, @Param("status") String status, @Param("comment_status") String comment_status);

    @Modifying
    @Query("UPDATE MedicalWaste " +
            "SET waste_1 = :waste_1 , waste_2 = :waste_2, waste_3 = :waste_3, waste_4 = :waste_4, waste_5 = :waste_5," +
            "waste_6 = :waste_6 , waste_7 = :waste_7, waste_8 = :waste_8 , waste_9 = :waste_9, waste_10 = :waste_10 , waste_11 = :waste_11," +
            "waste_12 = :waste_12 , waste_13 = :waste_13, waste_14 = :waste_14 , otchet_a_b = :otchet_a_b,otchet_a = :otchet_a " +
            "WHERE cvartl = :cvartl  and years = :years")
    void findAllByYearsCvartal(@Param("cvartl") Integer cvartl, @Param("years") Integer years,
                               @Param("waste_1") Integer waste_1, @Param("waste_2") Integer waste_2, @Param("waste_3") Integer waste_3,
                               @Param("waste_4") Integer waste_4, @Param("waste_5") Integer waste_5, @Param("waste_6") Integer waste_6,
                               @Param("waste_7") Integer waste_7, @Param("waste_8") Integer waste_8, @Param("waste_9") Integer waste_9,
                               @Param("waste_10") Integer waste_10, @Param("waste_11") Integer waste_11, @Param("waste_12") Integer waste_12,
                               @Param("waste_13") Integer waste_13, @Param("waste_14") Integer waste_14,
                               @Param("otchet_a_b") Integer otchet_a_b, @Param("otchet_a") Integer otchet_a);


    @Query(value = "select c.years AS years, " +
            "SUM (c.waste_1) AS waste_1 , SUM (c.waste_2) AS waste_2, SUM (c.waste_3) AS waste_3 , SUM (c.waste_4) AS waste_4 , " +
            "SUM (c.waste_5) AS waste_5 , SUM (c.waste_6) AS waste_6, SUM (c.waste_7) AS waste_7, SUM (c.otchet_a_b) AS otchet_a_b " +
            "FROM medic_otx c GROUP BY c.years ",nativeQuery = true)
    List<MedicalWasteSumDtoRepository> findAllStatistics(@RequestParam Integer years, @RequestParam Integer waste_1,@RequestParam Integer waste_2, @RequestParam Integer waste_3,
                                         @RequestParam  Integer waste_4, @RequestParam Integer waste_5, @RequestParam Integer waste_6,
                                         @RequestParam Integer waste_7, @RequestParam Integer otchet_a_b);

    @Query(value = "select c.years AS years, " +
            "SUM (c.waste_1) AS waste_1 " +
            "FROM medic_otx c GROUP BY c.years " +
            "HAVING c.years = 2022", nativeQuery = true)
    List<MedicalWaste1Repository> findWaste1(@Param("years") Integer years, @Param("waste_1") Integer waste_1);

}
