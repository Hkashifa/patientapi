package com.javatechie.patientapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "doctor")
@EqualsAndHashCode(callSuper = false)
public class Doctor extends Base{

    @Column(name = "department")
    private String Department;

    @Column(name = "specialisation")
    private String Specialisation;

    @Column(name = "room")
    private int Room;


}
