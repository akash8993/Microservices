package com.akash.employeeservice.service;

import com.akash.employeeservice.dto.EmployeeDto;
import com.akash.employeeservice.entity.Employee;
import com.akash.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;
    public EmployeeDto saveEmployee(EmployeeDto employeeDto)
    {
        Employee employee= modelMapper.map(employeeDto, Employee.class);
       Employee savedEmployee= employeeRepository.save(employee);
       return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    public EmployeeDto findEmployeeById(Long id) {
        Employee employee= employeeRepository.findById(id).get();
        return modelMapper.map(employee, EmployeeDto.class);

    }
}
