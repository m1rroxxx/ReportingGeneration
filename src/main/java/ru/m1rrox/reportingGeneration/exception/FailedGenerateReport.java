package ru.m1rrox.reportingGeneration.exception;

public class FailedGenerateReport extends RuntimeException {
    public FailedGenerateReport(Exception e) {
        super(e);
    }
}
