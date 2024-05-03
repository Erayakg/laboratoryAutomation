package com.example.demo.controller;

import com.example.demo.entity.Report;
import com.example.demo.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/report")
public class ReportController {

   // private final ReportService reportService;
//
//    public ReportController(ReportService reportService) {
//        this.reportService = reportService;
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Report> getReportById(@PathVariable Long id){
//        return new ResponseEntity<>(reportService.getbyid(id), HttpStatus.OK);
//    }

}
