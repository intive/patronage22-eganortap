package com.intive.patronage22eganortap.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@Deprecated
@Tag(name = "TeamMembers", description = "Demo endpoints")
public class HelloTeamController {


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
