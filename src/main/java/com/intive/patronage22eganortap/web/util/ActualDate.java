package com.intive.patronage22eganortap.web.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActualDate {
    
    private static final DateTimeFormatter standardFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static String getStandardDate() {
        return LocalDateTime.now().format(standardFormat);
    }
}
