package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Laborant extends BaseEntity{

    private String ad;
    private String soyad;
    private String kimlikNumarasi;
}
