package com.akash.organizationservice.controller;

import com.akash.organizationservice.dto.OrganizationDto;
import com.akash.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Microservice - Organization Controller",
        description = "This controller exposes Rest-API's for the Organization service"
)
@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;
    @Operation(
            summary = "Save Organization REST API",
            description = "This api is used to save the Organization Details to mysql database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )

    @PostMapping("/save")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.saveOrganization(organizationDto));
    }
    @Operation(
            summary = "Get Organization REST API",
            description = "This api is used to get the Organization from mysql database using Organization code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/getByCode/{orgCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String orgCode)
    {
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.getOrganizationByCode(orgCode));
    }
}
