package com.akash.employeeservice.controller;

import com.akash.employeeservice.dto.APIResponseDto;
import com.akash.employeeservice.dto.EmployeeDto;
import com.akash.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Employee Microservice - Employee Controller",
        description = "This controller exposes Rest-API's for the Employee service"
)
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(
            summary = "Save Employee REST API",
            description = "This api is used to save the Employee to mysql database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Employee REST API",
            description = "This api is used to get the Employee from mysql database using Employee code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/find/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }
}
