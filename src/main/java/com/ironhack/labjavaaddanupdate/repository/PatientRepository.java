package com.ironhack.labjavaaddanupdate.repository;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import com.ironhack.labjavaaddanupdate.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> findByDateOfBirthBetween(LocalDate firstDate, LocalDate lastDate);
    public List<Patient> findByAdmittedByDepartmentIgnoreCase(String department);
    public List<Patient> findByAdmittedByStatus(StatusEnum status);
}
