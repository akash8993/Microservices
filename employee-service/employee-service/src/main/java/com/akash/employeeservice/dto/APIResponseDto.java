package com.akash.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "API Response DTO Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    @Schema(
            name = "Employee DTO For single response"
    )
    private EmployeeDto employeeDto;

    @Schema(
            name = "Department DTO For single response"
    )
    private DepartmentDto departmentDto;

    //Now calling organization also for the response in single
    @Schema(
            name = "Organization DTO For single response"
    )
    private OrganizationDto organizationDto;
}
