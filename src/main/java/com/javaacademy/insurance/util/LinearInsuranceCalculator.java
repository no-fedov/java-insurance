package com.javaacademy.insurance.util;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class LinearInsuranceCalculator {
    public static BigDecimal calculatePriceForInsurance(BigDecimal rateCoefficient, BigDecimal coverageAmount,
                                                        BigDecimal priceForRegistrationInsurance) {
        return coverageAmount.multiply(rateCoefficient).add(priceForRegistrationInsurance);
    }
}
