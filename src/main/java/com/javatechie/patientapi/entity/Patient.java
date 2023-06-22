package com.javatechie.patientapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;

    @Column(name = "phone_ number")
    private String phone_number;


    @Column(name = "illness")
    private String illness;

    @Column(name = "activeStatus")
    private ActiveStatus activeStatus = ActiveStatus.ACTIVE;

}
