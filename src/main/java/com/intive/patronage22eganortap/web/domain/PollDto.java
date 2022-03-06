package com.intive.patronage22eganortap.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PollDto {

    private Long id;

    @Size(max = 25)
    @NotBlank
    private String name;

    @Size(max = 50)
    @NotBlank
    private String description;

    @Email
    @NotBlank
    private String email;

    @Min(0)
    @NotNull
    private int timer;

    private LocalDateTime startDate;

    @URL
    @NotBlank
    private String link;

    @Enumerated(EnumType.STRING)
    @NotNull
    private String status;

    private boolean open;

    @Size(max = 25)
    private List<QuestionDto> questions;
}
