package com.akash.employeeservice.controller;

import com.akash.employeeservice.dto.APIResponseDto;
import com.akash.employeeservice.dto.EmployeeDto;
import com.akash.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }
}
