package com.example.demo.services;

import com.example.demo.dto.request.PatientReqDTO;
import com.example.demo.dto.response.PatientResDTO;
import com.example.demo.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    PatientResDTO savePatient(PatientReqDTO patientReqDTO);

    void deletePatient(Long id);

    PatientResDTO updatePatient(Long id,PatientReqDTO patientReqDTO);

    PatientResDTO getPatientById(Long id);

    List<PatientResDTO> getAllPatient();

    Patient getPatientByid(Long id);


}
