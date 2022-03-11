package com.intive.patronage22eganortap.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Deprecated
@Tag(name = "TeamMembers", description = "Demo endpoints")
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

    @Deprecated(forRemoval = true)
    @GetMapping("/hello")
    @Operation(description = "Welcome message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message send"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello Cebularze!");
    }
}
