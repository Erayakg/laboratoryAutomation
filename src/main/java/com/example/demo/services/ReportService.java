package com.example.demo.services;

import com.example.demo.dto.request.ReportReqDTO;
import com.example.demo.dto.response.ReportResDTO;
import com.example.demo.dto.response.ReportResIdDTO;
import com.example.demo.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {

    ReportResIdDTO saveReport(ReportReqDTO reportReqDTO);

    void deleteReport(Long id);

    ReportResIdDTO updateReport(Long id, ReportReqDTO reportReqDTO);

    Report getbyid(Long id);

    List<ReportResDTO> reportList();
    List<ReportResDTO> getReportListByLaboratoryWorkerId(Long laboratoryWorkerId);


    List<ReportResDTO> getReportListByPatientId(Long patientId);

    List<ReportResDTO> getReportListByLaboratoryWorkerName(String name);

    List<ReportResDTO> getReportListByPatientName(String name);
}
