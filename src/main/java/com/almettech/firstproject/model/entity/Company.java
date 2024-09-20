package com.almettech.firstproject.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Company extends BaseCsvEntity {

    private String companyName;
    private String type;
}
