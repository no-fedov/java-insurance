package com.javaacademy.insurance.service;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;

import java.math.BigDecimal;

public interface InsuranceService {
    InsuranceContract insuranceOffer(BigDecimal coverageAmount, String client, InsuranceType insuranceType);
    InsuranceContract payForInsurance(String insuranceNumber);
}
