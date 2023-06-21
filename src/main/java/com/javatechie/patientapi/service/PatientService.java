package com.javatechie.patientapi.service;


import com.javatechie.patientapi.dto.PatientDTO;
import com.javatechie.patientapi.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {


    List<PatientDTO> getAllPatient();

    public PatientDTO createPatient(PatientDTO patientDto);

    public PatientDTO updatePatient(long id, PatientDTO patientRequestDTO);



    PatientDTO deletePatient(long id);

    PatientDTO getPatientById(long id);


}
