package com.javatechie.patientapi.repository;

import com.javatechie.patientapi.entity.Doctor;
import com.javatechie.patientapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
