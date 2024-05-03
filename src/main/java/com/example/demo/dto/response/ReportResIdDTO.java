package com.example.demo.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReportResIdDTO {
    private Long laboratoryWorkerId;
    private Long patientId;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private LocalDate issueDate;
    private String photoUrl;
}
