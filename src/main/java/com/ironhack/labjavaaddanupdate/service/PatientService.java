package com.ironhack.labjavaaddanupdate.service;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import com.ironhack.labjavaaddanupdate.model.Employee;
import com.ironhack.labjavaaddanupdate.model.Patient;
import com.ironhack.labjavaaddanupdate.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;

    public void saveAll(List<Patient> patientList) {
        log.info("saving all patients");
        patientRepository.saveAll(patientList);
    }

    public List<Patient> getAllPatients() {
        log.info("getting all patients");
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientByID(int patientId) {
        log.info("getting patient by ID: {}", patientId);
        return patientRepository.findById(patientId);
    }

    public List<Patient> getPatientsByDateOfBirthRange(LocalDate firstDate, LocalDate lastDate) {
        log.info("getting patient with birthdate in between: {} - {}", firstDate, lastDate);
        return patientRepository.findByDateOfBirthBetween(firstDate, lastDate);
    }

    public List<Patient> getPatientsByAdmittingDoctorsDepartment(String department) {
        log.info("getting patients with admitting doctor department: {}", department.toLowerCase());
        return patientRepository.findByAdmittedByDepartmentIgnoreCase(department);
    }

    public List<Patient> getAllPatientsWithADoctorWhoseStatusIsOFF() {
        log.info("getting patients with admitting doctor status: OFF");
        return patientRepository.findByAdmittedByStatus(StatusEnum.OFF);
    }

    @Transactional
    public Patient addNewPatient(Patient patient) {
        log.info("adding new patient: {}", patient.getName());
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient updatePatientInformation(int id, Patient patient) {
        log.info("updating patient information; ID: {}", id);
        Patient patientToUpdate = patientRepository.findById(id).orElseThrow();
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
        patientToUpdate.setAdmittedBy(patient.getAdmittedBy());
        return patientRepository.save(patientToUpdate);
    }
}
