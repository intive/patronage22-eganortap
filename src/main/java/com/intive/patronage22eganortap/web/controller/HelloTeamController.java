package com.intive.patronage22eganortap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@Deprecated
public class HelloTeamController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/")
    public String hello() {
        return messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale());
    }
}
