package com.ironhack.labjavaaddanupdate.repository;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import com.ironhack.labjavaaddanupdate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByStatus(StatusEnum status);
    public List<Employee> findByDepartmentIgnoreCase(String department);
}
