package ru.m1rrox.reportingGeneration.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.m1rrox.reportingGeneration.dto.ReportRequest;
import ru.m1rrox.reportingGeneration.service.ReportService;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<byte[]> generateReport(@RequestBody @Valid ReportRequest reportRequest) {

        byte[] reportBytes = reportService.generateReport(reportRequest);
        String fileName = String.format("%s.%s", reportRequest.getReportName() , reportRequest.getOutputFormat().name().toLowerCase());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentLength(reportBytes.length);

        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }
}
