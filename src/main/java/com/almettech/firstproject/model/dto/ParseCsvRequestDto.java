package com.almettech.firstproject.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ParseCsvRequestDto {

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OutputType type;

    @NotNull
    private MultipartFile csvFile;
}
