package com.example.demo.controller;

import com.example.demo.dto.ReportReqDTO;
import com.example.demo.dto.ReportResDTO;
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
    public ResponseEntity<ReportResDTO> saveReport(@RequestBody ReportReqDTO reportReqDTO){
        return new ResponseEntity<>(reportService.saveReport(reportReqDTO),HttpStatus.CREATED);
    }

}
