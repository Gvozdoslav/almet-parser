package com.almettech.firstproject.service.impl;

import com.almettech.firstproject.model.dto.ParseCsvResponseDto;
import com.almettech.firstproject.model.entity.*;
import com.almettech.firstproject.model.wrapper.FirstTaskEntitiesWrapper;
import com.almettech.firstproject.service.CsvRowsToClassParser;
import com.almettech.firstproject.service.mapper.CsvProcessedDataModelMapper;
import com.almettech.firstproject.util.CsvHelper;
import com.almettech.firstproject.util.ParsedModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service to parse List of raw String[] rows to Java-classes {@link ParseCsvResponseDto}
 */
@Service
@RequiredArgsConstructor
public class FirstTaskCsvRowsToClassParserImpl implements CsvRowsToClassParser<FirstTaskEntitiesWrapper> {

    private final static Class<Employee> EMPLOYEE_CLASS = Employee.class;
    private final static Class<BankAccount> BANK_ACCOUNT_CLASS = BankAccount.class;
    private final static Class<Company> COMPANY_CLASS = Company.class;
    private final static Class<Individual> INDIVIDUAL_CLASS = Individual.class;

    private final List<CsvProcessedDataModelMapper> dataModelMappers;

    @Override
    @SuppressWarnings("unchecked")
    public FirstTaskEntitiesWrapper parse(List<String[]> rows) {
        List<ParsedModel> parsedModels = CsvHelper.extractModels(rows);

        return FirstTaskEntitiesWrapper.builder()
                .bankAccounts((List<BankAccount>) getProcessedCsvEntities(getParsedModelByClass(parsedModels, BANK_ACCOUNT_CLASS)))
                .employees((List<Employee>) getProcessedCsvEntities(getParsedModelByClass(parsedModels, EMPLOYEE_CLASS)))
                .individuals((List<Individual>) getProcessedCsvEntities(getParsedModelByClass(parsedModels, INDIVIDUAL_CLASS)))
                .companies((List<Company>) getProcessedCsvEntities(getParsedModelByClass(parsedModels, COMPANY_CLASS)))
                .build();
    }

    private List<? extends BaseCsvEntity> getProcessedCsvEntities(ParsedModel parsedModel) {
        var dataModelMapper = dataModelMappers.stream()
                .filter(mapper -> parsedModel.modelClass().equals(mapper.getMappingClass()))
                .findFirst()
                .orElse(null);

        if (Objects.isNull(dataModelMapper)) {
            return List.of();
        }

        return dataModelMapper.map(parsedModel);
    }

    private ParsedModel getParsedModelByClass(List<ParsedModel> parsedModels, Class<?> clazz) {
        return parsedModels.stream()
                .filter(parsedModel -> clazz.equals(parsedModel.modelClass()))
                .findFirst()
                .orElse(null);
    }


}
