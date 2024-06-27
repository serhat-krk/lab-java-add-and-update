package com.ironhack.labjavaaddanupdate.model;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_table")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @Digits(integer = 6, fraction = 0)
    private int id;

    @Pattern(regexp = "^[a-zA-Z]*$")
    private String department;

    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
