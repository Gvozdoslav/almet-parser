package com.almettech.firstproject.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BankAccount extends BaseCsvEntity {

    private String iban;
    private String bic;
    private String accountHolder;
}
