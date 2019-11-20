package io.springgeeks.duka.domain.formatters;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    public String pattern;

    public LocalDateFormatter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return pattern;
    }
}
