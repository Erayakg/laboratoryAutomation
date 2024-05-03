package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Embeddable
public class BaseAdditionalsFields {

    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    @PrePersist
    private void prePersist() {
        this.createDate= LocalDateTime.now();
    }
    @PreUpdate
    private void preUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
