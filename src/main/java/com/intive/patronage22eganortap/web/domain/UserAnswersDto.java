package com.intive.patronage22eganortap.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAnswersDto {

    private Long pollId;
    private List<UserAnswerDto> answers;

}
