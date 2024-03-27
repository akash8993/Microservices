package com.akash.departmentservice.controller;

import com.akash.departmentservice.dto.DepartmentDto;
import com.akash.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Microservice - Department Controller",
        description = "This controller exposes Rest-API's for the department service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST API",
            description = "This api is used to save the department to mysql database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/add")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto savedDepartment= departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Department REST API",
            description = "This api is used to get the department from mysql database using department code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/getDepartment/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentCode)
    {
       return new ResponseEntity<>
               (departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
    }

}
