package com.intive.patronage22eganortap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Patronage22EganortapApplication {

    public static void main(String[] args) {
        SpringApplication.run(Patronage22EganortapApplication.class, args);
    }

}
