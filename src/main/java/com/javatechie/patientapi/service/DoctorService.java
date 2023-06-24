package com.javatechie.patientapi.service;

import com.javatechie.patientapi.dto.DoctorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface DoctorService {
    List<DoctorDto> getAllDoctor();

    public DoctorDto createDoctor(DoctorDto doctorDto);

    public DoctorDto updateDoctor(Integer id, DoctorDto doctorDto);

   void deleteDoctor(@PathVariable long id);

    DoctorDto getDoctorById(long id);

}
