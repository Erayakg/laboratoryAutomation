package com.example.demo.controller;

import com.example.demo.dto.request.LaboratoryWorkerReqDTO;
import com.example.demo.dto.response.LaboratoryWorkerResDTO;
import com.example.demo.services.LaboratoryWorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/laboratory")
public class LaboratoryWorkerController {

    private final LaboratoryWorkerService laboratoryWorkerService;

    public LaboratoryWorkerController(LaboratoryWorkerService laboratoryWorkerService) {
        this.laboratoryWorkerService = laboratoryWorkerService;
    }

    @GetMapping("/search")
    public ResponseEntity<LaboratoryWorkerResDTO> getLaboratoryWorkerByName(@RequestParam String name){
        return new ResponseEntity<>(laboratoryWorkerService.getLaboratoryWorkerByName(name),HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<LaboratoryWorkerResDTO>> getAllLaboratory(){
        return new ResponseEntity<>(laboratoryWorkerService.getAllLaboratory(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryWorkerResDTO> getLaboratoryById(@PathVariable Long id){
        return new ResponseEntity<>(laboratoryWorkerService.getLaboratoryWorkerById(id),HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<LaboratoryWorkerResDTO> savePatient(@RequestBody LaboratoryWorkerReqDTO laboratoryWorkerReqDTO){
        return new  ResponseEntity<>(laboratoryWorkerService.saveLaboratoryWorker(laboratoryWorkerReqDTO),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LaboratoryWorkerResDTO> updatePatientById(@PathVariable Long id,@RequestBody  LaboratoryWorkerReqDTO laboratoryWorkerReqDTO){
        return new ResponseEntity<>(laboratoryWorkerService.updateLaboratoryWorker(id,laboratoryWorkerReqDTO),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        laboratoryWorkerService.deleteLaboratoryWorker(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
