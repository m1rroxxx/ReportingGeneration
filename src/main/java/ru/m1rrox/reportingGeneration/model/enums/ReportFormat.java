package ru.m1rrox.reportingGeneration.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import ru.m1rrox.reportingGeneration.exception.UnsupportedFormatException;

public enum ReportFormat {
    TXT,
    CSV,
    XLS;

    @JsonCreator
    public static ReportFormat fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Format cannot be null");
        }
        String upperValue = value.toUpperCase();
        try {
            return ReportFormat.valueOf(upperValue);
        } catch (IllegalArgumentException e) {
            throw new UnsupportedFormatException(value);
        }
    }
}
