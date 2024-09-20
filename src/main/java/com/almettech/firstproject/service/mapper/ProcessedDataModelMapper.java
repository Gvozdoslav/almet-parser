package com.almettech.firstproject.service.mapper;

import com.almettech.firstproject.util.ParsedModel;

import java.util.List;

public interface ProcessedDataModelMapper<T> {

    Class<? extends T> getMappingClass();

    List<? extends T> map(ParsedModel parsedModel);
}
