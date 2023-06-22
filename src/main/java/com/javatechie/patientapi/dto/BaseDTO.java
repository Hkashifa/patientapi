package com.javatechie.patientapi.dto;

import lombok.Data;

@Data
public class BaseDTO {

    protected int id;
    protected String name;
    protected String email;
    protected String phone_number;
}
