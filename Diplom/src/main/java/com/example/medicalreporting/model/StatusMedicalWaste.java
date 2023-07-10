package com.example.medicalreporting.model;

import jakarta.persistence.*;

import javax.validation.constraints.Null;

@Entity
@Table(name = "status_report")
public class StatusMedicalWaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    public String getComment_status() {
        return comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }

    @Null
    @Column(name = "comment_status")
    private String comment_status;

    public StatusMedicalWaste() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public StatusMedicalWaste(String status, String comment_status) {
        this.status = status;
        this.comment_status = comment_status;
    }

    @Override
    public String toString() {
        return "StatusMedicalWaste{" +
                "id=" + id +
                ", status=" + status +
                ", comment_status=" + comment_status +
                '}';
    }
}
