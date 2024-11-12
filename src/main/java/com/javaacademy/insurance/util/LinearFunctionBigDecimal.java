package com.javaacademy.insurance.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LinearFunctionBigDecimal {
    public static BigDecimal calculateValueOfLinearFunction(BigDecimal angularCoefficient, BigDecimal abscissa,
                                                            BigDecimal freeCoefficient) {
        return abscissa.multiply(angularCoefficient).add(freeCoefficient);
    }
}
