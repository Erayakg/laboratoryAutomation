package com.example.demo.services;

import com.example.demo.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Optional<Patient> savePatient(Patient patient);

    void deletePatient(Long id);

    Optional<Patient> updatePatient(Long id);

    Optional<Patient> getPatientById(Long id);

    Optional<List<Patient>> getAllPatient();


}
