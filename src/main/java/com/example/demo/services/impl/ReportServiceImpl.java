package com.example.demo.services.impl;

import com.example.demo.dto.request.ReportReqDTO;
import com.example.demo.dto.response.LaboratoryWorkerResDTO;
import com.example.demo.dto.response.PatientResDTO;
import com.example.demo.dto.response.ReportResDTO;
import com.example.demo.dto.response.ReportResIdDTO;
import com.example.demo.exceptions.ReportNotFoundException;
import com.example.demo.repository.ReportRepository;
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
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public ReportResIdDTO updateReport(Long id, ReportReqDTO reportReqDTO) {
        Report report=reportRepository.findById(id).orElseThrow(()->
                new ReportNotFoundException("Report not found id:"+id));
        report.setDiagnosisTitle(reportReqDTO.getDiagnosisTitle());
        report.setDiagnosisDetails(reportReqDTO.getDiagnosisDetails());

        Report saveReport=reportRepository.save(report);
        ReportResIdDTO reportResDTO=mapToDto(saveReport);



        return reportResDTO;
    }

    @Override
    public Report getbyid(Long id) {
        return reportRepository.findById(id).orElseThrow(()->new ReportNotFoundException("Report not found"));
    }

    @Override
    public List<ReportResDTO> reportList() {
        List<Report> reportList=reportRepository.findAll();
        List<ReportResDTO>  reportResIdDTOS=mapToDtoList(reportList);
        return reportResIdDTOS;
    }

    @Override
    public List<ReportResDTO> getReportListByLaboratoryWorkerId(Long laboratoryWorkerId) {
        List<Report> reportList=reportRepository.findByLaboratoryWorkerId(laboratoryWorkerId);
        List<ReportResDTO>  reportResDTOS=mapToDtoList(reportList);

        return reportResDTOS;
    }

    @Override
    public List<ReportResDTO> getReportListByPatientId(Long patientId) {

        List<Report> reportList=reportRepository.findByPatientId(patientId);
        List<ReportResDTO>  reportResDTOS=mapToDtoList(reportList);

        return reportResDTOS;
    }

    @Override
    public List<ReportResDTO> getReportListByLaboratoryWorkerName(String name) {
        List<Report> reportList=reportRepository.findByLaboratoryWorkerName(name);
        List<ReportResDTO> reportResDTOList=mapToDtoList(reportList);
        return reportResDTOList;
    }

    @Override
    public List<ReportResDTO> getReportListByPatientName(String name) {
        List<Report> reportList=reportRepository.findByPatientName(name);
        List<ReportResDTO> reportResDTOList=mapToDtoList(reportList);
        return reportResDTOList;
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

    public static List<ReportResDTO> mapToDtoList(List<Report> reports) {
        return reports.stream().map(report -> {
            ReportResDTO dto = new ReportResDTO();
            dto.setDiagnosisDetails(report.getDiagnosisDetails());
            dto.setIssueDate(report.getIssueDate());
            PatientResDTO patientResDTO=patientService.getPatientById(report.getPatient().getId());
            LaboratoryWorkerResDTO laboratoryWorkerResDTO=laboratoryWorkerService.getLaboratoryWorkerById(report.getLaboratoryWorker().getId());
            dto.setPatientResDTO(patientResDTO);
            dto.setLaboratoryWorkerResDTO(laboratoryWorkerResDTO);
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
