package com.intive.patronage22eganortap.web.service;

import com.intive.patronage22eganortap.web.domain.*;
import com.intive.patronage22eganortap.web.mapper.PossibleAnswerMapper;
import com.intive.patronage22eganortap.web.mapper.QuestionMapper;
import com.intive.patronage22eganortap.web.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PollServiceTest {

    @Autowired
    private PollService pollService;

    @Transactional
    @Test
    void updateAnswers() {
        //Given
        PossibleAnswer firstAnswer = PossibleAnswer.builder()
                .content("First option").build();
        PossibleAnswer secondAnswer = PossibleAnswer.builder()
                .content("Second option").build();
        PossibleAnswer thirdAnswer = PossibleAnswer.builder()
                .content("Third option").build();

        Question firstQuestion = Question.builder()
                .id(1L)
                .content("This is first question")
                .possibleAnswers(Set.of(firstAnswer, secondAnswer, thirdAnswer))
                .userAnswers(new HashSet<>())
                .build();

        Question secondQuestion = Question.builder()
                .id(2L)
                .content("This is second question")
                .possibleAnswers(Set.of(firstAnswer, secondAnswer, thirdAnswer))
                .userAnswers(new HashSet<>())
                .build();

        List<Question> questions = List.of(
                firstQuestion,
                secondQuestion
        );

        Poll poll = Poll.builder()
                .id(1L)
                .name("Test Poll")
                .description("This is test poll")
                .startDate(LocalDateTime.now())
                .email("jan@kowalski.com")
                .link("http://this-is-link")
                .status(PollStatus.DRAFT)
                .timer(15)
                .open(true)
                .questions(questions)
                .build();

        firstQuestion.setPoll(poll);
        secondQuestion.setPoll(poll);
        pollService.savePoll(poll);

        List<UserAnswer> answers = List.of(
                new UserAnswer(
                        1L,
                        "sessionId",
                        firstQuestion,
                        secondAnswer),
                new UserAnswer(
                        2L,
                        "sessionId",
                        firstQuestion,
                        thirdAnswer)
        );

        //When
        pollService.updateAnswers(1L, answers);
        Optional<Poll> updatedPoll = pollService.getPoll(1L);
        List<Question> updatedQuestions = updatedPoll.get().getQuestions();
        int answersQuantity = updatedQuestions.get(0).getUserAnswers().size();

        //Then
        assertEquals(2, answersQuantity);
    }

}