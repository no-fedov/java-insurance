package com.javaacademy.insurance.contract;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class InsuranceContract {
    private final String number;
    private final BigDecimal cost;
    private final BigDecimal coverageAmount;
    private final String currency;
    private final String client;
    private final String country;
    private final InsuranceType insuranceType;
    @Setter
    private ContractStatus contractStatus;
}
