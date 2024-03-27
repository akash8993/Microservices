package com.akash.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(
        description = "Department DTO Model Information"
)
@Data
public class DepartmentDto {

    private Long id;

    @Schema(
            name = "Department Name"
    )
    private String departmentName;
    @Schema(
            name = "Department Description"
    )
    private String departmentDescription;
    @Schema(
            name = "Department Code"
    )
    private String departmentCode;
}
