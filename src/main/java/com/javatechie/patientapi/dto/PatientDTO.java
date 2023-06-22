package com.javatechie.patientapi.dto;
import lombok.Data;

@Data
public class PatientDTO {

    private int id;
    private String name;
    private String email;
    private String phone_number;
    private String illness;
    private String activeStatus;
}
