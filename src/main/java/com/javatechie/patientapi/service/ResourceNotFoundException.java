package com.javatechie.patientapi.service;



public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String patient, String id, long id1) {

        System.out.println("The Post"+patient+"id"+id+"id_num:"+id1+"is not found");
    }
}
