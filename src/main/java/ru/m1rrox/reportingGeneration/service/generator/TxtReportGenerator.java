package ru.m1rrox.reportingGeneration.service.generator;

import org.springframework.stereotype.Component;
import ru.m1rrox.reportingGeneration.model.enums.ReportFormat;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class TxtReportGenerator implements ReportGenerator {
    @Override
    public byte[] generate(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public boolean supported(ReportFormat format) {
        return format.equals(ReportFormat.TXT);
    }
}
