package com.akash.employeeservice.service;

import com.akash.employeeservice.dto.APIResponseDto;
import com.akash.employeeservice.dto.DepartmentDto;
import com.akash.employeeservice.dto.EmployeeDto;
import com.akash.employeeservice.entity.Employee;
import com.akash.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    //for calling to department service
   // private RestTemplate restTemplate;

   // private WebClient webClient;

    private ApiClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto)
    {
        Employee employee= modelMapper.map(employeeDto, Employee.class);
       Employee savedEmployee= employeeRepository.save(employee);
       return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto findEmployeeById(Long id) {
        Employee employee= employeeRepository.findById(id).get();

        //Here we have created the Rest Template Call for the department data
//        ResponseEntity<DepartmentDto> responseEntity=restTemplate
//                .getForEntity("http://localhost:8080/api/departments/getDepartment/"+
//                        employee.getDepartmentCode()
//        , DepartmentDto.class);
//        DepartmentDto departmentDto= responseEntity.getBody();

//        DepartmentDto departmentDto= webClient.get().
//                uri("http://localhost:8080/api/departments/getDepartment/"+
//                        employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

       DepartmentDto departmentDto=apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto= modelMapper.map(employee, EmployeeDto.class);
        APIResponseDto apiResponseDto= new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }

    public APIResponseDto getDefaultDepartment(Long id){
        Employee employee= employeeRepository.findById(id).get();

        DepartmentDto departmentDto= new DepartmentDto();
        departmentDto.setDepartmentCode("RD0001");
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentDescription("Research and development department");

        EmployeeDto employeeDto= modelMapper.map(employee, EmployeeDto.class);
        APIResponseDto apiResponseDto= new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
