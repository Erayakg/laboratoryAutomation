package com.example.demo.dao;

import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report,Long> {

    List<Report> findByLaboratoryWorkerId(Long LaboratoryWorkerId);
    List<Report> findByPatientId(Long patientId);
}
