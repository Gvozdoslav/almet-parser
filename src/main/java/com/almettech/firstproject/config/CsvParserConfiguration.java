package com.almettech.firstproject.config;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvParserConfiguration {

    @Value("${server.config.csv.delimiter:,}")
    private char delimiter;

    @Bean
    public CSVParser csvParser() {
        return new CSVParserBuilder()
                .withSeparator(delimiter)
                .build();
    }
}
