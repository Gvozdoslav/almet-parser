package com.almettech.firstproject.service.mapper;

import com.almettech.firstproject.model.entity.BaseCsvEntity;
import com.almettech.firstproject.model.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyProcessedDataModelMapper extends CsvProcessedDataModelMapper {

    @Override
    public Class<? extends BaseCsvEntity> getMappingClass() {
        return Company.class;
    }
}
