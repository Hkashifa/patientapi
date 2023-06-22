package com.javatechie.patientapi.service;


import com.javatechie.patientapi.dto.PatientDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface PatientService {


    List<PatientDTO> getAllPatient();

    public PatientDTO createPatient(PatientDTO patientDto);

    public PatientDTO updatePatient(Integer id, PatientDTO patientRequestDTO);



    public PatientDTO deletePatient(@PathVariable long id, @RequestBody PatientDTO patientDto);

    PatientDTO getPatientById(long id);


}
