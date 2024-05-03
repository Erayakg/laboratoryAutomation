package com.example.demo.exceptions;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String msg) {
    super(msg);
    }
}
