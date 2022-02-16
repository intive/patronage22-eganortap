package com.intive.patronage22eganortap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Deprecated(forRemoval = true)
@Data
@AllArgsConstructor
public class TeamMember {
    @Schema(example = "1")
    private long id;

    @Schema(example = "Ala")
    private String name;

    @Schema(example = "Kowalska")
    private String surname;

    @Schema(example = "assassin")
    private String skill;
}
