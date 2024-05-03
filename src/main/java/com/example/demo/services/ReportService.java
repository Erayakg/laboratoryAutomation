package com.example.demo.services;

import com.example.demo.dto.ReportReqDTO;
import com.example.demo.dto.ReportResIdDTO;
import com.example.demo.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {

    ReportResIdDTO saveReport(ReportReqDTO reportReqDTO);

    void deletePatient(Long id);

    Report updatePatient(Long id);

    Report getbyid(Long id);

    List<Report> reportList();
    List<ReportResIdDTO> getReportListByLaboratoryWorkerId(Long laboratoryWorkerId);


    List<ReportResIdDTO> getReportListByPatientId(Long patientId);
}
