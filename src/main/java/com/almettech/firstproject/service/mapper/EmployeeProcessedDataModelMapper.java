package com.almettech.firstproject.service.mapper;

import com.almettech.firstproject.model.entity.BaseCsvEntity;
import com.almettech.firstproject.model.entity.Employee;
import org.springframework.stereotype.Component;


@Component
public class EmployeeProcessedDataModelMapper extends CsvProcessedDataModelMapper {

    @Override
    public Class<? extends BaseCsvEntity> getMappingClass() {
        return Employee.class;
    }
}
