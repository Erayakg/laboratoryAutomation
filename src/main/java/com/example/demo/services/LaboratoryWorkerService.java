package com.example.demo.services;

import com.example.demo.dto.request.LaboratoryWorkerReqDTO;
import com.example.demo.dto.response.LaboratoryWorkerResDTO;
import com.example.demo.entity.LaboratoryWorker;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LaboratoryWorkerService {

    LaboratoryWorkerResDTO saveLaboratoryWorker(LaboratoryWorkerReqDTO laboratoryWorkerReqDTO);

    void deleteLaboratoryWorker(Long id);

    LaboratoryWorkerResDTO updateLaboratoryWorker(Long id,LaboratoryWorkerReqDTO laboratoryWorkerReqDTO);

    LaboratoryWorkerResDTO getLaboratoryWorkerById(Long id);

    List<LaboratoryWorkerResDTO> getAllLaboratory();

    LaboratoryWorker getLaboratoryWorkerByid(Long id);

    LaboratoryWorkerResDTO getLaboratoryWorkerByName(String name);
}
