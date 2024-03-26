package com.akash.organizationservice.controller;

import com.akash.organizationservice.dto.OrganizationDto;
import com.akash.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.saveOrganization(organizationDto));
    }

    @GetMapping("/getByCode/{orgCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String orgCode)
    {
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.getOrganizationByCode(orgCode));
    }
}
