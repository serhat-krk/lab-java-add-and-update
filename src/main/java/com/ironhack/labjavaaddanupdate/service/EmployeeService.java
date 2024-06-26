package com.ironhack.labjavaaddanupdate.service;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import com.ironhack.labjavaaddanupdate.model.Employee;
import com.ironhack.labjavaaddanupdate.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void saveAll(List<Employee> employeeList) {
        log.info("saving all employees");
        employeeRepository.saveAll(employeeList);
    }

    public List<Employee> getAllDoctors() {
        log.info("getting all doctors");
        return employeeRepository.findAll();
    }

    public Optional<Employee> getDoctorByID(int employeeId) {
        log.info("getting doctor by ID: {}", employeeId);
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getDoctorsByStatus(StatusEnum status) {
        log.info("getting doctors by status: {}", status);
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getDoctorsByDepartment(String department) {
        log.info("getting doctors by department: {}", department.toLowerCase());
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

    @Transactional
    public Employee addNewDoctor(Employee employee) {
        log.info("adding new doctor: {}", employee.getName());
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee changeDoctorStatus(int id, StatusEnum status) {
        log.info("changing doctor status; ID: {}, New Status: {}", id, status);
        Employee doctorToUpdate = employeeRepository.findById(id).orElseThrow();
        doctorToUpdate.setStatus(status);
        return employeeRepository.save(doctorToUpdate);
    }

    @Transactional
    public Employee updateDoctorDepartment(int id, String department) {
        log.info("updating doctor's department; ID: {}, New Department: {}", id, department);
        Employee doctorToUpdate = employeeRepository.findById(id).orElseThrow();
        doctorToUpdate.setDepartment(department);
        return employeeRepository.save(doctorToUpdate);
    }
}
