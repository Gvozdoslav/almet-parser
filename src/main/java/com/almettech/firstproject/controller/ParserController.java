package com.almettech.firstproject.controller;

import com.almettech.firstproject.model.dto.ParseCsvRequestDto;
import com.almettech.firstproject.model.dto.ParseCsvResponseDto;
import com.almettech.firstproject.service.ParserService;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;

    @PostMapping("/parse")
    public ResponseEntity<ParseCsvResponseDto> parse(@ModelAttribute ParseCsvRequestDto request) {
        try {
            return ResponseEntity.ok(parserService.parse(request));
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
