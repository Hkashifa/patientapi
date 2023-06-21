package com.javatechie.patientapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
