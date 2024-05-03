package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Getter
@Setter
@Embeddable
public class BaseAdditionalsFields {
    @CreatedDate()
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

}
