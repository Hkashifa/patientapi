package com.javatechie.patientapi.service.impl;

import com.javatechie.patientapi.dto.DoctorDto;
import com.javatechie.patientapi.entity.Doctor;
import com.javatechie.patientapi.repository.DoctorRepository;
import com.javatechie.patientapi.service.DoctorService;
import com.javatechie.patientapi.util.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final ModelMapper modelMapper;
    private final DoctorRepository doctorRepository;


    public DoctorServiceImpl(ModelMapper modelMapper, DoctorRepository doctorRepository) {
        this.modelMapper = modelMapper;
        this.doctorRepository = doctorRepository;
    }


    @Override
    public List<DoctorDto> getAllDoctor() {

        List<Doctor> all_doctors = doctorRepository.findAll();
        return all_doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctorConverted = modelMapper.map(doctorDto, Doctor.class);
        doctorRepository.save(doctorConverted);

        DoctorDto doctorResponse = modelMapper.map(doctorConverted, DoctorDto.class);
        return doctorResponse;
    }

    @Override
    public DoctorDto updateDoctor(Integer id, DoctorDto doctorDto) {
        //Dto to entity
        Doctor doctorEntityResponse = modelMapper.map(doctorDto, Doctor.class);
        Optional<Doctor> updated_doctor = doctorRepository.findById(id);

        if (updated_doctor.isPresent()) {
            Doctor doctor_entity = updated_doctor.get();

            doctor_entity.setFirstName(doctorEntityResponse.getFirstName());
            doctor_entity.setLastName(doctorEntityResponse.getLastName());
            doctor_entity.setEmail(doctorEntityResponse.getEmail());
            doctor_entity.setPhoneNumber(doctorEntityResponse.getPhoneNumber());
            doctor_entity.setDepartment(doctorEntityResponse.getDepartment());
            doctor_entity.setSpecialisation(doctorEntityResponse.getSpecialisation());
            doctor_entity.setDegree(doctorEntityResponse.getDegree());

            doctorRepository.save(doctor_entity);//
            // entity to DTO
            DoctorDto doctorResponse = modelMapper.map(doctor_entity, DoctorDto.class);
            return doctorResponse;
        }
        return null;
    }

    @Override
    public void deleteDoctor(long id) {
        Doctor doctor = doctorRepository.findById((int) id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));

        doctorRepository.delete(doctor);
    }

    @Override
    public DoctorDto getDoctorById(long id) {
        Doctor doctor = doctorRepository.findById((int) id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        return modelMapper.map(doctor, DoctorDto.class);
    }
}
