package com.intive.patronage22eganortap.web.controller.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.*;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.validation.ConstraintViolationProblem;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler implements ProblemHandling{

    private final String TIMESTAMP = "timestamp";
    private final String VIOLATIONS = "violations";
    private final String MESSAGE = "message";

    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            NativeWebRequest request) {
        BindingResult result = exception.getBindingResult();
        System.out.println(">>>>>>>>>>>>>> ArgumentNotValid");
        Problem problem = Problem.builder()
                .with(TIMESTAMP, LocalDateTime.now().toString().replace("T", " "))
                .withTitle("Method argument not valid")
                .withStatus(defaultConstraintViolationStatus())
                .with(VIOLATIONS, createViolations(result))
                .build();
        return create(exception, problem, request);
    }

    @Override
    public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {
        if (Objects.isNull(entity)) {
            return entity;
        }
        Problem problem = entity.getBody();

        if (!(problem instanceof ConstraintViolationProblem || problem instanceof DefaultProblem)) {
            return entity;
        }
        ProblemBuilder builder = Problem.builder()
                .with(TIMESTAMP, LocalDateTime.now().toString())
                .withType(Problem.DEFAULT_TYPE.equals(problem.getType()) ? Problem.DEFAULT_TYPE : problem.getType())
                .withStatus(problem.getStatus())
                .withTitle(problem.getTitle());

        if (problem instanceof ConstraintViolationProblem) {
            builder
                    .with(VIOLATIONS, ((ConstraintViolationProblem) problem).getViolations())
                    .with(MESSAGE, "Data integrity error");
        } else {
            builder
                    .withCause(((DefaultProblem) problem).getCause())
                    .withDetail(problem.getDetail())
                    .withInstance(problem.getInstance());
            problem.getParameters().forEach(builder::with);
            System.out.println(">>>>>>>>>>>>>> DeafultProblem");
        }
        return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Problem> handleNoSuchElementException(NoSuchElementException exception, NativeWebRequest request) {
        Problem problem = Problem.builder()
                .withTitle("Element not found")
                .withStatus(Status.NOT_FOUND)
                .with(MESSAGE, exception.getMessage())
                .build();

        return create(exception, problem, request);
    }
}
