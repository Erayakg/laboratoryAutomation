package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Embeddable
public class BaseAdditionalsFields {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long createdBy;
    private Long updatedBy;

    @PrePersist
    private void prePersist() {
        this.createDate= LocalDateTime.now();
    }


    @PreUpdate
    private void preUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
