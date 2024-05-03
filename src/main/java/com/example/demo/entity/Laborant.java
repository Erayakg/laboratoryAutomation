package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Laborant extends BaseEntity{
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String ad;
    private String soyad;
    private String kimlikNumarasi;





}
