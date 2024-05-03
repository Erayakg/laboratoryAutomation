package com.example.demo.services.impl;

import com.example.demo.dao.PatientRepository;
import com.example.demo.dto.PatientReqDTO;
import com.example.demo.dto.PatientResDTO;
import com.example.demo.entity.Patient;
import com.example.demo.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResDTO savePatient(PatientReqDTO patientReqDTO) {

        Patient patient = mapToDto(patientReqDTO);

        Patient savePatient = patientRepository.save(patient);

        PatientResDTO patientResDTO = mapToDto(patient);

        return patientResDTO;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public Optional<PatientResDTO> updatePatient(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PatientResDTO> getPatientById(Long id) {

        return Optional.empty();
    }

    @Override
    public List<PatientResDTO> getAllPatient() {
        List<Patient> patientAll = patientRepository.findAll();
        List<PatientResDTO> patientResDTOS = this.mapToDtoList(patientAll);
        return patientResDTOS;
    }

    public static PatientResDTO mapToDto(Patient patient) {
        PatientResDTO dto = new PatientResDTO();
        dto.setName(patient.getName());
        dto.setSurName(patient.getSurName());
        dto.setMail(patient.getMail());
        return dto;
    }

    public static List<PatientResDTO> mapToDtoList(List<Patient> patients) {
        return patients.stream().map(patient -> {
            PatientResDTO dto = new PatientResDTO();
            dto.setName(patient.getName());
            dto.setSurName(patient.getSurName());
            dto.setMail(patient.getMail());
            return dto;
        }).collect(Collectors.toList());
    }
    public static Patient mapToDto(PatientReqDTO patientReqDTO) {
        Patient patient = new Patient();
        patient.setName(patientReqDTO.getName());
        patient.setSurName(patientReqDTO.getSurName());
        patient.setMail(patientReqDTO.getMail());
        return patient;
    }

}
