package ru.m1rrox.reportingGeneration.service.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.m1rrox.reportingGeneration.model.enums.ReportFormat;
import ru.m1rrox.reportingGeneration.service.generator.ReportGenerator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportGeneratorFactory {

    private final List<ReportGenerator> generators;

    public ReportGenerator getGenerator(ReportFormat reportFormat) {
        return generators.stream()
                .filter(generator -> generator.supported(reportFormat))
                .findFirst()
                .orElse(null);
    }
}
