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
        //this is suppose to work hopefully
        return service.getAllPatient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable(name = "id") Long id) {

        return null;
    }

    @PostMapping("/addpatients")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto) {

        PatientDTO newpatient = service.createPatient(patientDto);
        return new ResponseEntity<PatientDTO> (newpatient, HttpStatus.CREATED);

    }


    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable long id, @RequestBody PatientDTO patientDto) {

        return ResponseEntity.ok().body(patientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePatient(@PathVariable(name = "id") Long id) {
        service.deletePatient(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }


}
