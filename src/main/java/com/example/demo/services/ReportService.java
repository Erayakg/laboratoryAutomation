package com.example.demo.services;

import com.example.demo.entity.Patient;
import com.example.demo.entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Optional<Report> saveReport(Patient patient);

    void deletePatient(Long id);

    Optional<Patient> updatePatient(Long id);

    Optional<Patient> getbyid(Long id);

    Optional<List<Patient>> patientList();


}
