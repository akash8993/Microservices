package com.akash.employeeservice.service;

import com.akash.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Here openfeign client will directly create the implementation of this

//Now here we have harcoded the url for the feign client and now we will use the name
// provided by eureka server
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("api/departments/getDepartment/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable String departmentCode);

}
