package ru.m1rrox.reportingGeneration.service.generator;

import ru.m1rrox.reportingGeneration.model.enums.ReportFormat;

import java.util.Map;

public interface ReportGenerator {
    byte[] generate(Map<String, Object> data);
    boolean supported(ReportFormat format);
}
