package com.akash.departmentservice.service;

import com.akash.departmentservice.dto.DepartmentDto;
import com.akash.departmentservice.entity.Department;
import com.akash.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;
    public DepartmentDto saveDepartment(DepartmentDto departmentDto)
    {
        Department department= modelMapper.map(departmentDto, Department.class);
        Department department1=departmentRepository.save(department);
        return modelMapper.map(department1, DepartmentDto.class);
    }

    public DepartmentDto getDepartmentByCode(String code)
    {
        Department department=departmentRepository.findByDepartmentCode(code);
        return modelMapper.map(department, DepartmentDto.class);
    }

}
