package com.akash.employeeservice.service;

import com.akash.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8083",value = "organization-service")
public interface OrganizationClient {

    @GetMapping("/api/organization/getByCode/{orgCode}")
    OrganizationDto getOrganizationByCode(@PathVariable String orgCode);
}
