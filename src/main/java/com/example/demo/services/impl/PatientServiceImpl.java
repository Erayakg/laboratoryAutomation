package com.example.demo.services.impl;

import com.example.demo.entity.Patient;
import com.example.demo.services.PatientService;

import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {
    @Override
    public Optional<Patient> savePatient(Patient patient) {
        return Optional.empty();
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public Optional<Patient> updatePatient(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Patient>> getAllPatient() {
        return Optional.empty();
    }


}
