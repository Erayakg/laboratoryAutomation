package com.example.demo.dto;

import lombok.Data;

@Data
public class PatientReqDTO {

    private String mail;
    private  String password;
    private String name;
    private String surName;
    private String patientNumber;

}
