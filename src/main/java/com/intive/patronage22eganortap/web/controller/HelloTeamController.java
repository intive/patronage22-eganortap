package com.intive.patronage22eganortap.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@Deprecated
public class HelloTeamController {

    @GetMapping("/")
    public String hello() {
        return "Hello Cebularze Team:)";
    }
}
