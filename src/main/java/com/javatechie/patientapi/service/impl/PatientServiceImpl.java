package com.javatechie.patientapi.service.impl;

import com.javatechie.patientapi.dto.PatientDto;
import com.javatechie.patientapi.entity.enums.ActiveStatus;
import com.javatechie.patientapi.entity.Patient;
import com.javatechie.patientapi.repository.PatientRepository;
import com.javatechie.patientapi.service.PatientService;
import com.javatechie.patientapi.util.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final ModelMapper modelMapper;
    private final PatientRepository patientRepository;

    public PatientServiceImpl(ModelMapper modelMapper, PatientRepository patientRepository) {
        super();
        this.modelMapper = modelMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> getAllPatient() {

        //DTO to Entity
        List<Patient> active_patients = new ArrayList<>();
        List<Patient> all_patients = patientRepository.findAll();

        for (Patient patient_holder : all_patients) {
            // Print all elements of ArrayList
            if (patient_holder.getActiveStatus() == ActiveStatus.ACTIVE) {

                active_patients.add(patient_holder);

            }
        }


        return active_patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patientConverted = modelMapper.map(patientDto, Patient.class);
        patientRepository.save(patientConverted);

        PatientDto patientResponse = modelMapper.map(patientConverted, PatientDto.class);
        return patientResponse;


    }


    //this works i tested it
    @Override
    public PatientDto updatePatient(Integer id, PatientDto patientdto) {

        //Dto to entity
        Patient patientEntityResponse = modelMapper.map(patientdto, Patient.class);
        Optional<Patient> updated_patient = patientRepository.findById(id);

        if (updated_patient.isPresent()) {
            Patient patient_entity = updated_patient.get();

            patient_entity.setFirstName(patientEntityResponse.getFirstName());
            patient_entity.setLastName(patientEntityResponse.getLastName());
            patient_entity.setGender(patientEntityResponse.getGender());
            patient_entity.setEmail(patientEntityResponse.getEmail());
            patient_entity.setAge(patient_entity.getAge());
            patient_entity.setAddress(patient_entity.getAddress());
            patient_entity.setContactNumber(patient_entity.getContactNumber());


            patientRepository.save(patient_entity);//
            // entity to DTO
            PatientDto patientResponse = modelMapper.map(patient_entity, PatientDto.class);
            return patientResponse;
        }
        return null;
    }

    @Override
    public PatientDto getPatientById(long id) {

        Patient patient = patientRepository.findById((int) id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public PatientDto deletePatient(@PathVariable long id, @RequestBody PatientDto patientDto) {

        PatientDto updated_patient = this.getPatientById(id);
        Patient patient_entity = modelMapper.map(updated_patient, Patient.class);

        patient_entity.setActiveStatus(ActiveStatus.INACTIVE);

        patientRepository.save(patient_entity);
        // entity to DTO
        PatientDto patientResponse = modelMapper.map(patient_entity, PatientDto.class);
        return patientResponse;

        //patientRepository.delete(patient);
    }


}
