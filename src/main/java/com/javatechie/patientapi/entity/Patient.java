package com.javatechie.patientapi.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "patient")
@EqualsAndHashCode(callSuper = false)
public class Patient extends Base{




    @Column(name = "illness")
    private String illness;

    @Column(name = "activeStatus")
    private ActiveStatus activeStatus = ActiveStatus.ACTIVE;


}
