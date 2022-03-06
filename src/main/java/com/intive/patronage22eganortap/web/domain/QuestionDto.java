package com.intive.patronage22eganortap.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {

    private Long id;

    private Poll poll;

    @Size(max = 200)
    @NotBlank
    private String content;

    private Set<UserAnswerDto> userAnswers;

    @Size(min = 2, max = 10)
    private Set<PossibleAnswerDto> possibleAnswers;
}
