package com.almettech.firstproject.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Individual extends BaseCsvEntity {

    private String firstName;
    private String lastName;
    private Boolean hasChildren;
    private Integer age;
}
