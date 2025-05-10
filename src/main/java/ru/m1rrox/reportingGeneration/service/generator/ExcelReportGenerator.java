package ru.m1rrox.reportingGeneration.service.generator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.m1rrox.reportingGeneration.exception.FailedGenerateReport;
import ru.m1rrox.reportingGeneration.model.enums.ReportFormat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Component
public class ExcelReportGenerator implements ReportGenerator {

    @Override
    public byte[] generate(Map<String, Object> data) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            int rowNum = 0;
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entry.getKey());

                Object value = entry.getValue();

                if (value == null) {
                    row.createCell(1).setCellValue("");
                    continue;
                }
                row.createCell(1).setCellValue(entry.getValue().toString());
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new FailedGenerateReport(e);
        }
    }

    @Override
    public boolean supported(ReportFormat format) {
        return format.equals(ReportFormat.XLS);
    }
}
