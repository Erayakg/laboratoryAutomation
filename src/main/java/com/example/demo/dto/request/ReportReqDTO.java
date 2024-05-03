package com.example.demo.dto.request;


import lombok.Data;

@Data
public class ReportReqDTO {
    private Long laboratoryWorkerId;
    private Long patientId;
    private String diagnosisTitle;
    private String diagnosisDetails;

}
