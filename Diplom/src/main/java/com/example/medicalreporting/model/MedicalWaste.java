package com.example.medicalreporting.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medic_otx")
public class MedicalWaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cvartl")
    private Integer cvartl;

    @Column(name = "years")
    private Integer years;

    @Column(name = "waste_1")
    private Integer waste_1;

    @Column(name = "waste_2")
    private Integer waste_2;

    @Column(name = "waste_3")
    private Integer waste_3;

    @Column(name = "waste_4")
    private Integer waste_4;

    @Column(name = "waste_5")
    private Integer waste_5;

    @Column(name = "waste_6")
    private Integer waste_6;

    @Column(name = "waste_7")
    private Integer waste_7;

    @Column(name = "waste_8")
    private Integer waste_8;

    @Column(name = "waste_9")
    private Integer waste_9;

    @Column(name = "waste_10")
    private Integer waste_10;

    @Column(name = "waste_11")
    private Integer waste_11;

    @Column(name = "waste_12")
    private Integer waste_12;

    @Column(name = "waste_13")
    private Integer waste_13;

    @Column(name = "waste_14")
    private Integer waste_14;

    @Column(name = "otchet_a_b")
    private Integer otchet_a_b;

    @Column(name = "otchet_a")
    private Integer otchet_a;


    public StatusMedicalWaste getStatusMedicalWastes() {
        return statusMedicalWastes;
    }

    public void setStatusMedicalWastes(StatusMedicalWaste statusMedicalWastes) {
        this.statusMedicalWastes = statusMedicalWastes;
    }

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id")
    private StatusMedicalWaste statusMedicalWastes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCvartl() {
        return cvartl;
    }

    public void setCvartl(Integer cvartl) {
        this.cvartl = cvartl;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getWaste_1() {
        return waste_1;
    }

    public void setWaste_1(Integer waste_1) {
        this.waste_1 = waste_1;
    }

    public Integer getWaste_2() {
        return waste_2;
    }

    public void setWaste_2(Integer waste_2) {
        this.waste_2 = waste_2;
    }

    public Integer getWaste_3() {
        return waste_3;
    }

    public void setWaste_3(Integer waste_3) {
        this.waste_3 = waste_3;
    }

    public Integer getWaste_4() {
        return waste_4;
    }

    public void setWaste_4(Integer waste_4) {
        this.waste_4 = waste_4;
    }

    public Integer getWaste_5() {
        return waste_5;
    }

    public void setWaste_5(Integer waste_5) {
        this.waste_5 = waste_5;
    }

    public Integer getWaste_6() {
        return waste_6;
    }

    public void setWaste_6(Integer waste_6) {
        this.waste_6 = waste_6;
    }

    public Integer getWaste_7() {
        return waste_7;
    }

    public void setWaste_7(Integer waste_7) {
        this.waste_7 = waste_7;
    }

    public Integer getWaste_8() {
        return waste_8;
    }

    public void setWaste_8(Integer waste_8) {
        this.waste_8 = waste_8;
    }

    public Integer getWaste_9() {
        return waste_9;
    }

    public void setWaste_9(Integer waste_9) {
        this.waste_9 = waste_9;
    }

    public Integer getWaste_10() {
        return waste_10;
    }

    public void setWaste_10(Integer waste_10) {
        this.waste_10 = waste_10;
    }

    public Integer getWaste_11() {
        return waste_11;
    }

    public void setWaste_11(Integer waste_11) {
        this.waste_11 = waste_11;
    }

    public Integer getWaste_12() {
        return waste_12;
    }

    public void setWaste_12(Integer waste_12) {
        this.waste_12 = waste_12;
    }

    public Integer getWaste_13() {
        return waste_13;
    }

    public void setWaste_13(Integer waste_13) {
        this.waste_13 = waste_13;
    }

    public Integer getWaste_14() {
        return waste_14;
    }

    public void setWaste_14(Integer waste_14) {
        this.waste_14 = waste_14;
    }

    public Integer getOtchet_a_b() {
        return otchet_a_b;
    }

    public void setOtchet_a_b(Integer otchet_a_b) {
        this.otchet_a_b = otchet_a_b;
    }

    public Integer getOtchet_a() {
        return otchet_a;
    }

    public void setOtchet_a(Integer otchet_a) {
        this.otchet_a = otchet_a;
    }


    @Override
    public String toString() {
        return "MedicalWaste{" +
                "id=" + id +
                ", cvartl=" + cvartl +
                ", years=" + years +
                ", waste_1=" + waste_1 +
                ", waste_2=" + waste_2 +
                ", waste_3=" + waste_3 +
                ", waste_4=" + waste_4 +
                ", waste_5=" + waste_5 +
                ", waste_6=" + waste_6 +
                ", waste_7=" + waste_7 +
                ", waste_8=" + waste_8 +
                ", waste_9=" + waste_9 +
                ", waste_10=" + waste_10 +
                ", waste_11=" + waste_11 +
                ", waste_12=" + waste_12 +
                ", waste_13=" + waste_13 +
                ", waste_14=" + waste_14 +
                ", otchet_a_b=" + otchet_a_b +
                ", otchet_a=" + otchet_a +
                ", statusMedicalWastes=" + statusMedicalWastes +
                '}';
    }
}
