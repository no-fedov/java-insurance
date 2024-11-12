package com.javaacademy.insurance.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsuranceNumberGenerator {
    private static int generatorId = 0;

    public static String generateInsuranceContractNumber() {
        return String.format("%010d", ++generatorId);
    }
}
