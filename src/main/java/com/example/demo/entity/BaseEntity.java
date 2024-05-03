package com.example.demo.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter

public abstract class BaseEntity implements Serializable,Cloneable,BaseEntityModel {

    @Embedded
    BaseAdditionalsFields baseAdditionalsFields;

}
