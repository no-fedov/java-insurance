package com.javaacademy.insurance.service;

import com.javaacademy.insurance.contract.InsuranceType;

import java.math.BigDecimal;

public interface InsuranceCalcService {
    BigDecimal calcInsuranceCost(BigDecimal coverageAmount, InsuranceType insuranceType);
}
