package com.example.demo.services;

import com.example.demo.dto.LaboratoryWorkerReqDTO;
import com.example.demo.dto.LaboratoryWorkerResDTO;
import com.example.demo.dto.PatientReqDTO;
import com.example.demo.dto.PatientResDTO;

import java.util.List;

public interface LaboratoryWorkerService {

    LaboratoryWorkerResDTO saveLaboratoryWorker(LaboratoryWorkerReqDTO laboratoryWorkerReqDTO);

    void deleteLaboratoryWorker(Long id);

    LaboratoryWorkerResDTO updateLaboratoryWorker(Long id,LaboratoryWorkerReqDTO laboratoryWorkerReqDTO);

    LaboratoryWorkerResDTO getLaboratoryWorkerById(Long id);

    List<LaboratoryWorkerResDTO> getAllLaboratory();
}
