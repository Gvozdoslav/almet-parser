package com.almettech.firstproject.model.mapper;

import com.almettech.firstproject.model.dto.ParseCsvResponseDto;
import com.almettech.firstproject.model.entity.Individual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper for {@link ParseCsvResponseDto}
 */
@Component
@Mapper(componentModel = "spring", uses = {EmployeeDtoMapper.class})
public interface ParseCsvResponseMapper {

    @Mapping(target = "personsNumber", source = "personsNumber")
    @Mapping(target = "companiesNumber", source = "companiesNumber")
    @Mapping(target = "employees", source = "individuals")
    ParseCsvResponseDto map(Integer personsNumber, Integer companiesNumber, List<Individual> individuals);
}
