package com.example.demo.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String,String> erors=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            String fieldName=((FieldError) error).getField();
            String errorMessage= error.getDefaultMessage();;
            erors.put(fieldName,errorMessage);
        });

        return new ResponseEntity<>(erors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ReportNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(PatientNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
    @ExceptionHandler(LaboratoryWorkerBotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(LaboratoryWorkerBotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }



}
