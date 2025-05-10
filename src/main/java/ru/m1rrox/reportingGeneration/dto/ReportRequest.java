package ru.m1rrox.reportingGeneration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.m1rrox.reportingGeneration.model.enums.ReportFormat;

import java.util.Map;

@Data
public class ReportRequest {
    @NotBlank
    @NotNull
    private String reportName;

    @NotNull
    private Map<String, Object> payloadData;

    private ReportFormat outputFormat;
}
