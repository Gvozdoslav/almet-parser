package com.almettech.firstproject.service.mapper;

import com.almettech.firstproject.model.entity.BaseCsvEntity;
import com.almettech.firstproject.model.entity.Individual;
import org.springframework.stereotype.Component;

@Component
public class IndividualProcessedDataModelMapper extends CsvProcessedDataModelMapper {

    @Override
    public Class<? extends BaseCsvEntity> getMappingClass() {
        return Individual.class;
    }
}
