package com.javatechie.patientapi.controller;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    Boolean success;
    String message;
    HttpStatus status;
    public ApiResponse(Boolean aTrue, String postDeletedSuccessfully, HttpStatus httpStatus) {
    }
}

