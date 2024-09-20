package com.almettech.firstproject.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class CsvHelper {

    private final static Integer ZERO_INDEX = 0;

    private final static Integer MODEL_CLASS_NAME_ROW_NUMBER = 0;
    private final static Integer MODEL_CLASS_NAME_POSITION_NUMBER = 0;
    private final static Integer MODEL_FIELDS_ROW_NUMBER = 1;
    private final static Integer MODEL_VALUES_ROW_NUMBER = 2;

    private final static String DEFAULT_CSV_MODEL_DELIMITER = "aboba";
    private final static Integer CSV_MODEL_DELIMITER_POSITION_NUMBER = 0;

    private final static String CSV_ENTITY_PATH = "com.almettech.firstproject.model.entity.";

    public Class<?> extractClassFromString(String className) {
        try {
            return Class.forName(CsvHelper.CSV_ENTITY_PATH +
                    FieldValueHelper.prepareNameField(className, true));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ParsedModel> extractModels(List<String[]> rows) {
        return extractModels(rows, CsvHelper.DEFAULT_CSV_MODEL_DELIMITER);
    }

    public List<ParsedModel> extractModels(List<String[]> rows, String modelDelimiter) {
        if (Objects.isNull(modelDelimiter)) {
            modelDelimiter = CsvHelper.DEFAULT_CSV_MODEL_DELIMITER;
        }

        final String finalModelDelimiter = modelDelimiter;
        List<Integer> modelBordersIndexes = new ArrayList<>();
        modelBordersIndexes.add(CsvHelper.ZERO_INDEX);
        modelBordersIndexes.addAll(
                IntStream.range(CsvHelper.ZERO_INDEX, rows.size())
                        .boxed()
                        .collect(Collectors.toMap(i -> i, rows::get))
                        .entrySet()
                        .stream()
                        .filter(pair -> finalModelDelimiter.equals(pair.getValue()[CsvHelper.CSV_MODEL_DELIMITER_POSITION_NUMBER]))
                        .map(pair -> pair.getKey() + 1)
                        .toList());

        return IntStream.range(0, modelBordersIndexes.size())
                .mapToObj(i -> {
                    if (i == modelBordersIndexes.size() - 1) {
                        return extractModel(rows.subList(modelBordersIndexes.get(i), rows.size()));
                    }

                    return extractModel(rows.subList(modelBordersIndexes.get(i), modelBordersIndexes.get(i + 1) - 1));
                })
                .toList();
    }

    public ParsedModel extractModel(List<String[]> rawModel) {
        return ParsedModel.builder()
                .modelClass(extractClassFromString(rawModel.get(CsvHelper.MODEL_CLASS_NAME_ROW_NUMBER)[CsvHelper.MODEL_CLASS_NAME_POSITION_NUMBER]))
                .fields(Arrays.stream(rawModel.get(CsvHelper.MODEL_FIELDS_ROW_NUMBER)).toList())
                .valueRows(rawModel.subList(CsvHelper.MODEL_VALUES_ROW_NUMBER, rawModel.size()))
                .build();
    }
}
