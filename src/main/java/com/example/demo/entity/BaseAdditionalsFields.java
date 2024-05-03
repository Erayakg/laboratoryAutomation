package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Embeddable
public class BaseAdditionalsFields {

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
