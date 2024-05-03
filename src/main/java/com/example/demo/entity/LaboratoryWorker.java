package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class LaboratoryWorker extends BaseEntity{
    @Id
    @Column(name = "worker_id")
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private String Surname;
    private String mail;
    private  String password;

    @Column(unique = true)
    private String LaboratoryWorkerNumber;

}
