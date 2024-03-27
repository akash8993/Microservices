package com.akash.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/*It is same as in Department bcoz we get the Department Dto in response so have to
* create it in order to get the data mapped here*/

@Schema(
        description = "Department DTO Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
