package com.almettech.firstproject.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Employee extends BaseCsvEntity {

    private Long id;
    private String email;
    private String phone;
    private String address;
}
