package com.example.demo.exceptions;

public class ReportNotFoundException extends RuntimeException{
    public ReportNotFoundException(String msg) {
        super(msg);
    }
}
