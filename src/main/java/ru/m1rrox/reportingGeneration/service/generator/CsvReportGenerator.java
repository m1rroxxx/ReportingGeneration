package ru.m1rrox.reportingGeneration.service.generator;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;
import ru.m1rrox.reportingGeneration.exception.FailedGenerateReport;
import ru.m1rrox.reportingGeneration.model.enums.ReportFormat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

@Component
public class CsvReportGenerator implements ReportGenerator {
    @Override
    public byte[] generate(Map<String, Object> data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream))) {

            writer.writeNext(data.keySet().toArray(new String[0]));

            writer.writeNext(data.values().stream()
                    .map(Object::toString)
                    .toArray(String[]::new));

            writer.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new FailedGenerateReport(e);
        }
    }

    @Override
    public boolean supported(ReportFormat format) {
        return format.equals(ReportFormat.CSV);
    }
}
