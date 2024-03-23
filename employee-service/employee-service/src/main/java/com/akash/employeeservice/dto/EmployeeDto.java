package com.akash.employeeservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    //Ye departmentCode is for calling the departmentService and humne dto mein bhi add kri
    //bcoz ye hi return krenge hum
    private String departmentCode;
}
