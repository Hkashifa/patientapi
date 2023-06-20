package com.javatechie.patientapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "PATIENT_TBL")

public class Patient {

    @Id
    @GeneratedValue
    private long idpatients;

    @Column(name = "name")
    private String name;

    @Column(name = "illness")
    private String illness;

    public Long getIdpatients() {
        return idpatients;
    }

    public void setIdpatients(long idpatients) {
        this.idpatients = idpatients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
