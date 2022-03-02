package com.intive.patronage22eganortap;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Patronage22EganortapApplication {

    public static void main(String[] args) {
        SpringApplication.run(Patronage22EganortapApplication.class, args);
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:pawelDB", "sa", null).load();
        flyway.migrate();
    }

}
