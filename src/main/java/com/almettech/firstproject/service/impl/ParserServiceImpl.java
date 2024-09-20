package com.almettech.firstproject.service.impl;

import com.almettech.firstproject.model.dto.ParseCsvRequestDto;
import com.almettech.firstproject.model.dto.ParseCsvResponseDto;
import com.almettech.firstproject.model.entity.Individual;
import com.almettech.firstproject.model.mapper.ParseCsvResponseMapper;
import com.almettech.firstproject.model.wrapper.FirstTaskEntitiesWrapper;
import com.almettech.firstproject.service.CsvRowsToClassParser;
import com.almettech.firstproject.service.ParserService;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParserServiceImpl implements ParserService {

    private static final Integer TWENTY_YEARS_AGE = 20;

    private final CSVParser csvParser;
    private final CsvRowsToClassParser<FirstTaskEntitiesWrapper> csvRowsToClassParser;
    private final ParseCsvResponseMapper parseCsvResponseMapper;

    @Override
    public ParseCsvResponseDto parse(ParseCsvRequestDto parseCsvRequestDto) throws IOException, CsvException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(parseCsvRequestDto.getCsvFile().getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        CSVReader csvReader = new CSVReaderBuilder(inputStreamReader)
                .withCSVParser(csvParser)
                .build();
        return mapIncomeEntitiesToResponse(csvRowsToClassParser.parse(csvReader.readAll()));
    }

    private ParseCsvResponseDto mapIncomeEntitiesToResponse(FirstTaskEntitiesWrapper wrapper) {

        List<Individual> individualsYoungerThan20 = wrapper.getIndividuals()
                .stream()
                .filter(individual -> individual.getAge() < TWENTY_YEARS_AGE)
                .toList();

        return parseCsvResponseMapper.map(wrapper.getEmployees().size(),
                wrapper.getCompanies().size(), individualsYoungerThan20);
    }
}
