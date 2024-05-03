package com.example.demo.dto.response;

import com.example.demo.dto.response.LaboratoryWorkerResDTO;
import com.example.demo.dto.response.PatientResDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportResDTO {
    private LaboratoryWorkerResDTO laboratoryWorkerResDTO;
    private PatientResDTO patientResDTO;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private LocalDate issueDate;
    private String photoUrl;
}
