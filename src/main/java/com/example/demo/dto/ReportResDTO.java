package com.example.demo.dto;

import com.example.demo.entity.LaboratoryWorker;
import com.example.demo.entity.Patient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportResDTO {
    private LaboratoryWorker laboratoryWorker;
    private Patient patient;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private LocalDate issueDate;
    private String photoUrl;
}
