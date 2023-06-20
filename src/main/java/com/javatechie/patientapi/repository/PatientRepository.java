package com.javatechie.patientapi.repository;

import com.javatechie.patientapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>
{
   // Patient findById(long id);
    //Patient findByName(String name);
}
