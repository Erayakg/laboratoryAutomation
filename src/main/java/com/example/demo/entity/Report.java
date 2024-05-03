package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Report {
    @ManyToOne
    @JoinColumn(name = "laborant_id")
    private Laborant laborant;

    @ManyToOne
    @JoinColumn(name = "hasta_id")
    private Patient patient;

    private String tanıBasligi;
    private String tanıDetayları;
    private LocalDate verilmeTarihi;
    private String fotoUrl;
}
