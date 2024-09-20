package com.almettech.firstproject.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ParseCsvRequestDto {

    private OutputType type;
    private MultipartFile csvFile;
}
