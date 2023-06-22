package com.javatechie.patientapi.controller;


import com.javatechie.patientapi.dto.PatientDTO;
import com.javatechie.patientapi.entity.Patient;

import com.javatechie.patientapi.service.PatientServiceImpl;
import com.javatechie.patientapi.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PatientController {

    private final ModelMapper modelMapper;
    private final PatientServiceImpl service;

    public PatientController(ModelMapper modelMapper,PatientServiceImpl service) {

        this.modelMapper = modelMapper;
        this.service = service;

    }

    //this works
    @GetMapping("/patients")
    public List<PatientDTO> getAllPatients() {

        return service.getAllPatient();
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable(name = "id") Long id) {
           //this works i tested it
        PatientDTO patientResponse = service.getPatientById(id);
        return ResponseEntity.ok().body(patientResponse);
    }

    @PostMapping("/patients/new")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto) {

        PatientDTO newPatient = service.createPatient(patientDto);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);

    }


    @PutMapping("patientupadate/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Integer id,@RequestBody PatientDTO patientDto) {

        PatientDTO newPatient = service.updatePatient(id,patientDto);

        return ResponseEntity.ok().body(newPatient);
    }

    @PutMapping("patientdelete/{id}")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable long id, @RequestBody PatientDTO patientDto) {


        PatientDTO newpatient = service.deletePatient(id,patientDto);

        return ResponseEntity.ok().body(newpatient);
    }


}
