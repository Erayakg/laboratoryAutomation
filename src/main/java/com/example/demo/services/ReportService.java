package com.example.demo.services;

import com.example.demo.entity.Patient;
import com.example.demo.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ReportService {

    Report saveReport(Patient patient);

    void deletePatient(Long id);

    Report updatePatient(Long id);

    Report getbyid(Long id);

    List<Report> reportList();
    List<Report> reportListByLaboratoryWorkerId(Long laboratoryWorkerId);


}
