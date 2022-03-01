package com.intive.patronage22eganortap.web.controller.exceptions;

import com.intive.patronage22eganortap.web.util.DateTimeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.*;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;
import org.zalando.problem.violations.ConstraintViolationProblem;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler implements ProblemHandling, SecurityAdviceTrait {

    private final String DATE = "date";
    private final String VIOLATIONS = "violations";
    private final String MESSAGE = "message";

    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            NativeWebRequest request) {
        BindingResult result = exception.getBindingResult();

        Problem problem = Problem.builder()
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
                .with(DATE, DateTimeUtils.getFullIsoDate(LocalDateTime.now()))
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

    @Override
    public ResponseEntity<Problem> handleAccessDenied(AccessDeniedException exception, NativeWebRequest request) {
        Problem problem = Problem.builder()
                .withTitle("Access denied")
                .withStatus(Status.FORBIDDEN)
                .with(MESSAGE, exception.getMessage())
                .build();
        return create(exception, problem, request);
    }

    @Override
    public ResponseEntity<Problem> handleAuthentication(AuthenticationException exception, NativeWebRequest request) {
        Problem problem = Problem.builder()
                .withTitle("Not authorized to perform operation")
                .withStatus(Status.UNAUTHORIZED)
                .with(MESSAGE, exception.getMessage())
                .build();
        return create(exception, problem, request);
    }
}
