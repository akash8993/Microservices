package com.akash.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Employee DTO Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    @Schema(
            name = "First Name"
    )
    private String firstName;

    @Schema(
            name = "Last Name"
    )
    private String lastName;

    @Schema(
            name = "Email"
    )
    private String email;

    //Ye departmentCode is for calling the departmentService and humne dto mein bhi add kri
    //bcoz ye hi return krenge hum
    @Schema(
            name = "Department Code for department service"
    )
    private String departmentCode;

    //Ye departmentCode is for calling the OrganizationService and humne dto mein bhi add kri
    //bcoz ye hi return krenge hum
    @Schema(
            name = "Organization Code for Organization Service call"
    )
    private String organizationCode;
}
