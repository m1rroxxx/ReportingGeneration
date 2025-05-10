package ru.m1rrox.reportingGeneration.exception;

public class UnsupportedFormatException extends RuntimeException {
    public UnsupportedFormatException(String format) {
      super("Unsupported format: " + format);
    }
}
