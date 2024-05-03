package com.example.demo.services;

import com.example.demo.dto.ReportReqDTO;
import com.example.demo.dto.ReportResDTO;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ReportService {

    ReportResDTO saveReport(ReportReqDTO reportReqDTO);

    void deletePatient(Long id);

    Report updatePatient(Long id);

    Report getbyid(Long id);

    List<Report> reportList();
    List<ReportResDTO> getReportListByLaboratoryWorkerId(Long laboratoryWorkerId);


    List<ReportResDTO> getReportListByPatientId(Long patientId);
}
