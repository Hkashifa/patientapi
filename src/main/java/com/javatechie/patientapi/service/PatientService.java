package com.javatechie.patientapi.service;


import com.javatechie.patientapi.dto.PatientDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface PatientService {

    List<PatientDto> getAllPatient();

    public PatientDto createPatient(PatientDto patientDto);

    public PatientDto updatePatient(Integer id, PatientDto patientdto);

    public PatientDto deletePatient(@PathVariable long id, @RequestBody PatientDto patientDto);

    PatientDto getPatientById(long id);

}
