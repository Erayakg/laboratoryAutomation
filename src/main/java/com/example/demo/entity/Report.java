package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Report extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
