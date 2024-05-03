package com.example.demo.services.impl;

import com.example.demo.dao.ReportRepository;
import com.example.demo.dto.*;
import com.example.demo.entity.LaboratoryWorker;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Report;
import com.example.demo.services.LaboratoryWorkerService;
import com.example.demo.services.PatientService;
import com.example.demo.services.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private static  PatientService patientService;
    private static  LaboratoryWorkerService laboratoryWorkerService;

    public ReportServiceImpl(ReportRepository reportRepository, PatientService patientService,
                             LaboratoryWorkerService laboratoryWorkerService) {
        this.reportRepository = reportRepository;
        this.patientService = patientService;
        this.laboratoryWorkerService=laboratoryWorkerService;

    }

    @Override
    public ReportResIdDTO saveReport(ReportReqDTO reportReqDTO) {
        Report report=mapToDto(reportReqDTO);
        Report saveReport=reportRepository.save(report);
        ReportResIdDTO reportResIdDTO=mapToDto(saveReport);
        return reportResIdDTO;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public Report updatePatient(Long id) {
        return null;
    }

    @Override
    public Report getbyid(Long id) {
        return null;
    }

    @Override
    public List<Report> reportList() {
        return null;
    }

    @Override
    public List<ReportResIdDTO> getReportListByLaboratoryWorkerId(Long laboratoryWorkerId) {
        List<Report> reportList=reportRepository.findByLaboratoryWorkerId(laboratoryWorkerId);
        List<ReportResIdDTO>  reportResIdDTOS=mapToDtoList(reportList);

        return reportResIdDTOS;
    }

    @Override
    public List<ReportResIdDTO> getReportListByPatientId(Long patientId) {

        List<Report> reportList=reportRepository.findByPatientId(patientId);
        List<ReportResIdDTO>  reportResIdDTOS=mapToDtoList(reportList);

        return reportResIdDTOS;
    }


    public static ReportResIdDTO mapToDto(Report report) {
        ReportResIdDTO dto = new ReportResIdDTO();
        dto.setDiagnosisDetails(report.getDiagnosisDetails());
        dto.setIssueDate(report.getIssueDate());
        dto.setPatientId(report.getPatient().getId());
        dto.setLaboratoryWorkerId(report.getLaboratoryWorker().getId());
        dto.setPhotoUrl(report.getPhotoUrl());
        dto.setDiagnosisTitle(report.getDiagnosisTitle());
        return dto;
    }

    public static List<ReportResIdDTO> mapToDtoList(List<Report> reports) {
        return reports.stream().map(report -> {
            ReportResIdDTO dto = new ReportResIdDTO();
            dto.setDiagnosisDetails(report.getDiagnosisDetails());
            dto.setIssueDate(report.getIssueDate());
            dto.setPatientId(report.getPatient().getId());
            dto.setLaboratoryWorkerId(report.getLaboratoryWorker().getId());
            dto.setPhotoUrl(report.getPhotoUrl());
            dto.setDiagnosisTitle(report.getDiagnosisTitle());
            return dto;
        }).collect(Collectors.toList());
    }
    public static Report mapToDto(ReportReqDTO reportReqDTO) {
        Report report = new Report();
        report.setDiagnosisDetails(reportReqDTO.getDiagnosisDetails());
        report.setDiagnosisTitle(reportReqDTO.getDiagnosisTitle());
        Patient patient= patientService.getPatientByid(reportReqDTO.getPatientId());
        report.setPatient(patient);
        LaboratoryWorker laboratoryWorker=laboratoryWorkerService.getLaboratoryWorkerByid(reportReqDTO.getLaboratoryWorkerId());
        report.setLaboratoryWorker(laboratoryWorker);

        return report;
    }

}
