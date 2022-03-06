package com.intive.patronage22eganortap.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAnswerDto {

    private Long id;

    private String sessionId;

    @NotBlank
    private QuestionDto question;

    @NotBlank
    private PossibleAnswerDto possibleAnswer;

}
