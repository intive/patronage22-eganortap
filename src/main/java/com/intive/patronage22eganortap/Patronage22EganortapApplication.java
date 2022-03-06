package com.intive.patronage22eganortap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intive.patronage22eganortap.web.domain.PollDto;
import com.intive.patronage22eganortap.web.domain.PossibleAnswerDto;
import com.intive.patronage22eganortap.web.domain.QuestionDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class Patronage22EganortapApplication {

    public static void main(String[] args) throws JsonProcessingException {


//        List<QuestionDto> questionDtos = List.of(new QuestionDto(
//                1L,
//                "this is first question",
//                null,
//                Set.of(new PossibleAnswerDto(
//                        123L,
//                        "this is possible answer"
//                ))));
//
//        PollDto pollDto = new PollDto(
//                1L,
//                "New poll",
//                "This is test poll",
//                "jan@kowalski.com",
//                45,
//                LocalDateTime.now(),
//                "link to poll",
//                "COMPLETED",
//                true,
//                questionDtos);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(pollDto);
//        System.out.println(jsonString);

        SpringApplication.run(Patronage22EganortapApplication.class, args);
    }
}
