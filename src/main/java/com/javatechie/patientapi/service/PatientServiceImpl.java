package com.javatechie.patientapi.service;

import com.javatechie.patientapi.dto.PatientDTO;
import com.javatechie.patientapi.entity.ActiveStatus;
import com.javatechie.patientapi.entity.Patient;
import com.javatechie.patientapi.repository.PatientRepository;
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
    public List<PatientDTO> getAllPatient() {

        //DTO to Entity


        List<Patient> active_patients = new ArrayList<>();
        List<Patient> all_patients = patientRepository.findAll();

        for (Patient patient_holder : all_patients) {
            // Print all elements of ArrayList
            if (patient_holder.getActiveStatus() == ActiveStatus.ACTIVE) {

                active_patients.add(patient_holder);

            }
        }


        return active_patients.stream().map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDto) {
        Patient patientConverted = modelMapper.map(patientDto, Patient.class);
        patientRepository.save(patientConverted);

        PatientDTO patientResponse = modelMapper.map(patientConverted, PatientDTO.class);
        return patientResponse;


    }


    //this works i tested it
    @Override
    public PatientDTO updatePatient(Integer id,PatientDTO patientdto) {

        //Dto to entity
        Patient patientEntityResponse = modelMapper.map(patientdto, Patient.class);
        Optional<Patient> updated_patient = patientRepository.findById(id);

        if (updated_patient.isPresent()) {
            Patient patient_entity = updated_patient.get();

            patient_entity.setName(patientEntityResponse.getName());
            patient_entity.setEmail(patientEntityResponse.getEmail());
            patient_entity.setPhone_number(patientEntityResponse.getPhone_number());
            patient_entity.setIllness(patientEntityResponse.getIllness());

            patientRepository.save(patient_entity);//
            // entity to DTO
            PatientDTO patientResponse = modelMapper.map(patient_entity, PatientDTO.class);
            return patientResponse;
        }
        return null;
    }

    @Override
    public PatientDTO getPatientById(long id) {

        Patient patient = patientRepository.findById((int) id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public PatientDTO deletePatient(@PathVariable long id, @RequestBody PatientDTO patientDto) {

        PatientDTO updated_patient = this.getPatientById(id);
        Patient patient_entity = modelMapper.map(updated_patient, Patient.class);

        patient_entity.setActiveStatus(ActiveStatus.INACTIVE);

        patientRepository.save(patient_entity);
        // entity to DTO
        PatientDTO patientResponse = modelMapper.map(patient_entity, PatientDTO.class);
        return patientResponse;

        //patientRepository.delete(patient);
    }


}
