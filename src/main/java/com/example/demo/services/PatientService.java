package com.example.demo.services;

import com.example.demo.dao.PatientRepository;
import com.example.demo.dto.PatientReqDTO;
import com.example.demo.dto.PatientResDTO;
import com.example.demo.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface PatientService {

    PatientResDTO savePatient(PatientReqDTO patientReqDTO);

    void deletePatient(Long id);

    PatientResDTO updatePatient(Long id,PatientReqDTO patientReqDTO);

    PatientResDTO getPatientById(Long id);

    List<PatientResDTO> getAllPatient();

    Patient getPatientByid(Long id);


}
