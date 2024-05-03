package com.example.demo.dto.request;

import lombok.Data;

@Data
public class PatientReqDTO {
    private String name;
    private String surName;
    private String mail;
    private  String password;
    private String patientNumber;

}
