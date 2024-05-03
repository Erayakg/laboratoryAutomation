package com.example.demo.controller;

import com.example.demo.dto.request.ReportReqDTO;
import com.example.demo.dto.response.ReportResDTO;
import com.example.demo.dto.response.ReportResIdDTO;
import com.example.demo.entity.Report;
import com.example.demo.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/report")
public class ReportController {

   private final ReportService reportService;

    public ReportController(ReportService reportService) {
       this.reportService = reportService;
   }

   @GetMapping("/search/LaboratoryWorker")
   public ResponseEntity<List<ReportResDTO>> getReportListByLaboratoryWorkerName(@RequestParam String name){
        return new ResponseEntity<>(reportService.getReportListByLaboratoryWorkerName(name),HttpStatus.OK);
   }
    @GetMapping("/search/patient")
    public ResponseEntity<List<ReportResDTO>> getReportListByPatientName(@RequestParam String name){
        return new ResponseEntity<>(reportService.getReportListByPatientName(name),HttpStatus.OK);
    }

  @GetMapping("{id}")
   public ResponseEntity<Report> getReportById(@PathVariable Long id){
       return new ResponseEntity<>(reportService.getbyid(id), HttpStatus.OK);
   }

    @GetMapping("/laboratoryWorker/{laboratoryWorkerId}")
    public ResponseEntity<List<ReportResDTO>> getReportListByLaboratoryWorkerId(@PathVariable Long laboratoryWorkerId){
        return new ResponseEntity<>(reportService.getReportListByLaboratoryWorkerId(laboratoryWorkerId),HttpStatus.FOUND);
    }

    @GetMapping("/patinet/{patientId}")
    public ResponseEntity<List<ReportResDTO>> getReportListByPatientId(@PathVariable Long patientId){
        return new ResponseEntity<>(reportService.getReportListByPatientId(patientId),HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<ReportResIdDTO> saveReport(@RequestBody ReportReqDTO reportReqDTO){
        return new ResponseEntity<>(reportService.saveReport(reportReqDTO),HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReportResIdDTO> updateReport(@PathVariable Long id,@RequestBody ReportReqDTO reportReqDTO){
        return new ResponseEntity<>(reportService.updateReport(id,reportReqDTO),HttpStatus.OK);
    }



}
