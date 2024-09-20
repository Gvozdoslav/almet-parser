package com.almettech.firstproject.model.wrapper;

import com.almettech.firstproject.model.entity.BankAccount;
import com.almettech.firstproject.model.entity.Company;
import com.almettech.firstproject.model.entity.Employee;
import com.almettech.firstproject.model.entity.Individual;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FirstTaskEntitiesWrapper {

    private List<Employee> employees;
    private List<Individual> individuals;
    private List<Company> companies;
    private List<BankAccount> bankAccounts;
}
