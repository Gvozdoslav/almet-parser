package com.almettech.firstproject.service;

import com.almettech.firstproject.model.dto.ParseCsvRequestDto;
import com.almettech.firstproject.model.dto.ParseCsvResponseDto;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public interface ParserService {

    ParseCsvResponseDto parse(ParseCsvRequestDto parseCsvRequestDto) throws IOException, CsvException;
}
