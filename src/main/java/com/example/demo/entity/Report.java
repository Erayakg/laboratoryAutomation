package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Report extends BaseEntity{
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private LaboratoryWorker laboratoryWorker;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    private String diagnosisTitle;
    private String diagnosisDetails;
    private LocalDate issueDate;

    private String photoUrl;
}
