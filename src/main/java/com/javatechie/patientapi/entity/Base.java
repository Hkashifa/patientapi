package com.javatechie.patientapi.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass
public class Base {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "name")
    protected String name;


    @Column(name = "email")
    protected String email;

    @Column(name = "phone_ number")
    protected String phone_number;

}
