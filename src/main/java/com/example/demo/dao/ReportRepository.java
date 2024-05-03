package com.example.demo.dao;

import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report,Long> {

    Optional<Report> findByLaboratoryWorkerId(Long LaboratoryWorkerId);
    Optional<Report> findByPatientId(Long patientId);
}
