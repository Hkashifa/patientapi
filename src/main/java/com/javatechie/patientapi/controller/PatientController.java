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


    @GetMapping("/patients")
    public List<PatientDTO> getAllPatients() {

        return service.getAllPatient().stream().map(post -> modelMapper.map(post, PatientDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable(name = "id") Long id) {
        Patient patient = service.getPatientById(id);

        // convert entity to DTO
        PatientDTO postResponse = modelMapper.map(patient, PatientDTO.class);

        return ResponseEntity.ok().body(postResponse);
    }

    @PostMapping("/addpatients")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto) {

        // convert DTO to entity
        Patient patientRequest = modelMapper.map(patientDto, Patient.class);

        Patient patient = service.createPatient(patientRequest);

        // convert entity to DTO
        PatientDTO postResponse = modelMapper.map(patient, PatientDTO.class);

        return new ResponseEntity<PatientDTO>(postResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable long id, @RequestBody PatientDTO patientDto) {

        // convert DTO to Entity
        Patient patientRequest = modelMapper.map(patientDto, Patient.class);

        Patient patient = service.updatePatient(id,  patientRequest);

        // entity to DTO
        PatientDTO  postResponse = modelMapper.map(patient,  PatientDTO .class);

        return ResponseEntity.ok().body(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePatient(@PathVariable(name = "id") Long id) {
        service.deletePatient(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }


}
