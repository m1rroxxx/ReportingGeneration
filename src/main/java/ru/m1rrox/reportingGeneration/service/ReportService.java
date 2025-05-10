package ru.m1rrox.reportingGeneration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.m1rrox.reportingGeneration.dto.ReportRequest;
import ru.m1rrox.reportingGeneration.service.factory.ReportGeneratorFactory;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportGeneratorFactory reportGeneratorFactory;

    public byte[] generateReport(ReportRequest reportRequest) {
        return reportGeneratorFactory
                .getGenerator(reportRequest.getOutputFormat())
                .generate(reportRequest.getPayloadData());
    }
}
