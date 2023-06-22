package com.javatechie.patientapi.dto;
import lombok.Data;

@Data
public class PatientDTO extends BaseDTO{

    private String illness;
    private String activeStatus;
}
