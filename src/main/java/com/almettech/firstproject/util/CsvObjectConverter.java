package com.almettech.firstproject.util;

import com.almettech.firstproject.model.entity.BaseCsvEntity;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.Map;

@UtilityClass
public class CsvObjectConverter {

    private final static String DEFAULT_CONVERT_EXCEPTION_MESSAGE = "Something went wrong when converting class: [{}] from processed rows";
    private final static String UNSUPPORTED_FIELD_TYPE_MESSAGE = "Unsupported field type: {}";

    public <T extends BaseCsvEntity> T convertMapToObject(Map<String, String> fieldNamesWithValues, Class<T> clazz) {
        T obj;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, String> entry : fieldNamesWithValues.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);

                Object convertedValue = convertToFieldType(field.getType(), entry.getValue());
                field.set(obj, convertedValue);
            }
        } catch (Exception e) {
            throw new RuntimeException(MessageFormat.format(DEFAULT_CONVERT_EXCEPTION_MESSAGE, clazz.getName()));
        }

        return obj;
    }

    private Object convertToFieldType(Class<?> fieldType, String value) {
        if (fieldType.equals(String.class)) {
            return value;
        } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
            return Integer.parseInt(value);
        } else if (fieldType.equals(long.class) || fieldType.equals(Long.class)) {
            return Long.parseLong(value);
        } else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
            return Boolean.parseBoolean(value);
        } else if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
            return Double.parseDouble(value);
        } else if (fieldType.equals(float.class) || fieldType.equals(Float.class)) {
            return Float.parseFloat(value);
        }

        throw new IllegalArgumentException(MessageFormat.format(UNSUPPORTED_FIELD_TYPE_MESSAGE, fieldType));
    }
}
