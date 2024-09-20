package com.almettech.firstproject.service.mapper;

import com.almettech.firstproject.model.entity.BaseCsvEntity;
import com.almettech.firstproject.util.CsvObjectConverter;
import com.almettech.firstproject.util.FieldValueHelper;
import com.almettech.firstproject.util.ParsedModel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class CsvProcessedDataModelMapper implements ProcessedDataModelMapper<BaseCsvEntity> {

    private final static Integer ZERO_INDEX = 0;
    private final static String DEFAULT_ERROR_MESSAGE = "An invalid line value was received for the Employee entity";

    @Override
    public List<? extends BaseCsvEntity> map(ParsedModel parsedModel) {
        return parsedModel.valueRows()
                .stream()
                .map(fieldValues -> mapSingleCsvEntity(FieldValueHelper.prepareNameFields(parsedModel.fields()),
                        FieldValueHelper.prepareNameFields(Arrays.stream(fieldValues).toList())))
                .toList();
    }

    public final BaseCsvEntity mapSingleCsvEntity(List<String> fieldNames, List<String> fieldValues) {
        if (fieldNames.size() != fieldValues.size() || fieldNames.size() != getMappingClass().getDeclaredFields().length) {
            throw new RuntimeException(DEFAULT_ERROR_MESSAGE);
        }

        Map<String, String> fieldNamesWithValues = IntStream.range(ZERO_INDEX, getMappingClass().getDeclaredFields().length)
                .boxed()
                .collect(Collectors.toMap(fieldNames::get, fieldValues::get));
        return CsvObjectConverter.convertMapToObject(fieldNamesWithValues, getMappingClass());
    }
}
