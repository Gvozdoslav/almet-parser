package com.almettech.firstproject.util;

import lombok.Builder;

import java.util.List;

@Builder
public record ParsedModel(
        Class<?> modelClass,
        List<String> fields,
        List<String[]> valueRows
) {
}