package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LaboratoryWorkerReqDTO {


    private String name;
    private String Surname;
    private String mail;
    private  String password;
    private String LaboratoryWorkerNumber;


}
