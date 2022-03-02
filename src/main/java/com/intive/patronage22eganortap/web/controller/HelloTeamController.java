package com.intive.patronage22eganortap.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Deprecated
public class HelloTeamController {

    private final MessageSource messageSource;

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        String message = messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale());
        return ResponseEntity.ok(message);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<String>  helloWithName() {
        String[] params = new String[]{"Intive"};
        String message = messageSource.getMessage("greeting.name", params, LocaleContextHolder.getLocale());
        return ResponseEntity.ok(message);
    }
}
