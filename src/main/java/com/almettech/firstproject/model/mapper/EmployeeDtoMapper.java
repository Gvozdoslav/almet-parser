package com.almettech.firstproject.model.mapper;

import com.almettech.firstproject.model.dto.EmployeeDto;
import com.almettech.firstproject.model.entity.Individual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * Mapper for {@link EmployeeDto}
 */
@Component
@Mapper(componentModel = "spring")
public interface EmployeeDtoMapper {

    @Mapping(target = "firstName", source = "source.firstName")
    @Mapping(target = "lastName", source = "source.lastName")
    EmployeeDto map(Individual source);
}
