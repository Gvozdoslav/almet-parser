package com.almettech.firstproject.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ParseCsvResponseDto {

    private Integer personsNumber;
    private Integer companiesNumber;
    private List<EmployeeDto> employees;
}
