package com.intive.patronage22eganortap.web.util;

import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public final class DateTimeUtils {

    private static final DateTimeFormatter fullIsoFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public String getFullIsoDate(LocalDateTime dateTime){
        return fullIsoFormat.format(dateTime);
    }
}
