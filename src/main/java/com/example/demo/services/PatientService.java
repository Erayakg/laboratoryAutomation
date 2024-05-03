package com.example.demo.services;

import com.example.demo.dao.PatientRepository;
import com.example.demo.dto.PatientReqDTO;
import com.example.demo.dto.PatientResDTO;
import com.example.demo.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    PatientResDTO savePatient(PatientReqDTO patientReqDTO);

    void deletePatient(Long id);

    Optional<PatientResDTO> updatePatient(Long id);

    Optional<PatientResDTO> getPatientById(Long id);

    List<PatientResDTO> getAllPatient();


}
