package com.example.demo.services.impl;

import com.example.demo.dao.LaboratoryWorkerRepository;
import com.example.demo.dto.LaboratoryWorkerReqDTO;
import com.example.demo.dto.LaboratoryWorkerResDTO;
import com.example.demo.dto.PatientResDTO;
import com.example.demo.entity.LaboratoryWorker;
import com.example.demo.entity.Patient;
import com.example.demo.services.LaboratoryWorkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaboratoryWorkerServiceImpl implements LaboratoryWorkerService {

    private final LaboratoryWorkerRepository laboratoryWorkerRepository;

    public LaboratoryWorkerServiceImpl(LaboratoryWorkerRepository laboratoryWorkerRepository) {
        this.laboratoryWorkerRepository = laboratoryWorkerRepository;
    }

    @Override
    public LaboratoryWorkerResDTO saveLaboratoryWorker(LaboratoryWorkerReqDTO laboratoryWorkerReqDTO) {

        LaboratoryWorker laboratoryWorker = mapToEntity(laboratoryWorkerReqDTO);

        LaboratoryWorker save = laboratoryWorkerRepository.save(laboratoryWorker);

        LaboratoryWorkerResDTO laboratoryWorkerResDTO = mapToResDTO(save);

        return laboratoryWorkerResDTO;
    }

    @Override
    public void deleteLaboratoryWorker(Long id) {

        LaboratoryWorker byId = laboratoryWorkerRepository.getReferenceById(id);

        laboratoryWorkerRepository.delete(byId);

    }

    @Override
    public LaboratoryWorkerResDTO updateLaboratoryWorker(Long id, LaboratoryWorkerReqDTO laboratoryWorkerReqDTO) {

        LaboratoryWorker byId = laboratoryWorkerRepository.getReferenceById(id);

            byId.setLaboratoryWorkerNumber(laboratoryWorkerReqDTO.getLaboratoryWorkerNumber());
            byId.setSurname(laboratoryWorkerReqDTO.getSurname());
            byId.setMail(laboratoryWorkerReqDTO.getMail());
            byId.setPassword(laboratoryWorkerReqDTO.getPassword());
            byId.setName(laboratoryWorkerReqDTO.getName());

        LaboratoryWorker save = laboratoryWorkerRepository.save(byId);

        LaboratoryWorkerResDTO laboratoryWorkerResDTO = mapToResDTO(byId);

        return laboratoryWorkerResDTO;
    }

    @Override
    public LaboratoryWorkerResDTO getLaboratoryWorkerById(Long id) {

        LaboratoryWorker byId = laboratoryWorkerRepository.getReferenceById(id);

        LaboratoryWorkerResDTO laboratoryWorkerResDTO = mapToResDTO(byId);

        return laboratoryWorkerResDTO;
    }

    @Override
    public List<LaboratoryWorkerResDTO> getAllLaboratory() {

        List<LaboratoryWorker> all = laboratoryWorkerRepository.findAll();

        List<LaboratoryWorkerResDTO> laboratoryWorkerResDTOS = mapToDtoList(all);

        return laboratoryWorkerResDTOS;
    }

    public LaboratoryWorkerResDTO mapToResDTO(LaboratoryWorker worker) {
        LaboratoryWorkerResDTO resDTO = new LaboratoryWorkerResDTO();
        resDTO.setName(worker.getName());
        resDTO.setSurname(worker.getSurname());
        resDTO.setMail(worker.getMail());
        resDTO.setLaboratoryWorkerNumber(worker.getLaboratoryWorkerNumber());
        return resDTO;
    }

    public LaboratoryWorker mapToEntity(LaboratoryWorkerReqDTO workerDTO) {
        LaboratoryWorker worker = new LaboratoryWorker();
        worker.setName(workerDTO.getName());
        worker.setSurname(workerDTO.getSurname());
        worker.setMail(workerDTO.getMail());
        worker.setPassword(workerDTO.getPassword());
        worker.setLaboratoryWorkerNumber(workerDTO.getLaboratoryWorkerNumber());
        return worker;
    }

    public static List<LaboratoryWorkerResDTO> mapToDtoList(List<LaboratoryWorker> laboratoryWorkers) {
        return laboratoryWorkers.stream().map(laboratoryWorker -> {
            LaboratoryWorkerResDTO dto = new LaboratoryWorkerResDTO();
            dto.setName(laboratoryWorker.getName());
            dto.setLaboratoryWorkerNumber(laboratoryWorker.getLaboratoryWorkerNumber());
            dto.setSurname(laboratoryWorker.getSurname());
            dto.setMail(laboratoryWorker.getMail());
            return dto;
        }).collect(Collectors.toList());
    }

}
