package com.akash.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;


@Schema(
        description = "Organization DTO Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationDto {
    private Long id;

    @Schema(
            name = "organizationName"
    )
    private String organizationName;

    @Schema(
            name = "organizationDescription"
    )
    private String organizationDescription;

    @Schema(
            name = "organizationCode"
    )
    private String organizationCode;

    @Schema(
            name = "createdDate"
    )
    private LocalDateTime createdDate;
}
