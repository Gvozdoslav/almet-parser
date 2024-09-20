package com.almettech.firstproject.service;

import java.util.List;

public interface CsvRowsToClassParser<T> {

    T parse(List<String[]> rows);
}
