package com.ironhack.labjavaaddanupdate.controller;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import com.ironhack.labjavaaddanupdate.model.Employee;
import com.ironhack.labjavaaddanupdate.model.StatusUpdateRequest;
import com.ironhack.labjavaaddanupdate.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getDoctorByID(@PathVariable("id") int employeeId) {
        return employeeService.getDoctorByID(employeeId);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable("status") StatusEnum status) {
        return employeeService.getDoctorsByStatus(status);
    }

    @GetMapping("department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable("department") String department) {
        return employeeService.getDoctorsByDepartment(department);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewDoctor(@RequestBody @Valid Employee employee) {
        return employeeService.addNewDoctor(employee);
    }

    @PatchMapping("/change-status/{id}")
    public Employee changeDoctorStatus(@PathVariable("id") int id, @RequestBody @Valid StatusUpdateRequest statusUpdateRequest) {
        return employeeService.changeDoctorStatus(id, statusUpdateRequest.getStatus());
    }

    @PatchMapping("/update-department/{id}")
    public Employee updateDoctorDepartment(@PathVariable("id") int id, @RequestBody @Valid @Pattern(regexp = "^[a-zA-Z]*$") String department) {
        return employeeService.updateDoctorDepartment(id, department);
    }


}
