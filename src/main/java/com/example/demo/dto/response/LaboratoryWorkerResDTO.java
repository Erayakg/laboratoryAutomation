package com.example.demo.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LaboratoryWorkerResDTO {

    private String name;
    private String Surname;
    private String mail;
    private String LaboratoryWorkerNumber;

}
