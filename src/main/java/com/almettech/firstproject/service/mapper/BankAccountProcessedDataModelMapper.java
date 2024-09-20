package com.almettech.firstproject.service.mapper;

import com.almettech.firstproject.model.entity.BankAccount;
import com.almettech.firstproject.model.entity.BaseCsvEntity;
import org.springframework.stereotype.Component;

@Component
public class BankAccountProcessedDataModelMapper extends CsvProcessedDataModelMapper {

    @Override
    public Class<? extends BaseCsvEntity> getMappingClass() {
        return BankAccount.class;
    }
}
