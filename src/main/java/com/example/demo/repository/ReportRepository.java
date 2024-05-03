package com.example.demo.repository;

import com.example.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Long> {

    List<Report> findByLaboratoryWorkerId(Long LaboratoryWorkerId);
    List<Report> findByPatientId(Long patientId);

    @Query("SELECT r FROM Report r JOIN r.laboratoryWorker lw WHERE lw.name = :laboratoryWorkerName")
    List<Report> findByLaboratoryWorkerName(@Param("laboratoryWorkerName") String laboratoryWorkerName);

    @Query("SELECT r FROM Report r JOIN r.patient p WHERE p.name = :patientName")
    List<Report> findByPatientName(@Param("patientName") String patientName);

}
