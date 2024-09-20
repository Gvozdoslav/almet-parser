package com.almettech.firstproject.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.text.CaseUtils;

import java.util.List;

@UtilityClass
public class FieldValueHelper {

    private final static char[] SUPPORTED_DELIMITERS = new char[]{' '};

    public List<String> prepareNameFields(List<String> row) {
        return row.stream()
                .map(FieldValueHelper::prepareNameField)
                .filter(nameField -> !nameField.isBlank())
                .toList();
    }

    public String prepareNameField(String nameField) {
        return prepareNameField(nameField.strip(), false);
    }

    public String prepareNameField(String nameField, boolean capitalizeFirstLetter) {
        return CaseUtils.toCamelCase(nameField, capitalizeFirstLetter, SUPPORTED_DELIMITERS);
    }

    public List<String> prepareValueFields(List<String> row) {
        return row.stream()
                .map(String::strip)
                .filter(valueField -> !valueField.isBlank())
                .toList();
    }
}
