package com.javatechie.patientapi.service;


import com.javatechie.patientapi.entity.Patient;
import com.javatechie.patientapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {


    List<Patient> getAllPatient();

    Patient createPatient(Patient patient);

    Patient updatePatient(long id, Patient patient);

    void deletePatient(long id);

    Patient getPatientById(long id);


}
