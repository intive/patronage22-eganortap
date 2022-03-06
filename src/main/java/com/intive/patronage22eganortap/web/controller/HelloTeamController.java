package com.intive.patronage22eganortap.web.controller;

import com.intive.patronage22eganortap.web.domain.PollDto;
import com.intive.patronage22eganortap.web.domain.UserAnswerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/api")
@RestController
@Deprecated
public class HelloTeamController {

    @GetMapping("/")
    public String hello() {
        return "Hello Cebularze Team:)";
    }
}
