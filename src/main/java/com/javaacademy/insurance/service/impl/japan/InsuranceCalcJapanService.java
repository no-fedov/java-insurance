package com.javaacademy.insurance.service.impl.japan;

import com.javaacademy.insurance.config.InsuranceProperty;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.service.InsuranceCalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.javaacademy.insurance.util.LinearInsuranceCalculator.*;

@Component
@Profile("japan")
@RequiredArgsConstructor
public class InsuranceCalcJapanService implements InsuranceCalcService {
    private static final BigDecimal ROBBERY_PAYMENT = BigDecimal.valueOf(10000);
    private static final BigDecimal MEDICAL_PAYMENT = BigDecimal.valueOf(12000);

    private final InsuranceProperty insuranceProperty;

    @Override
    public BigDecimal calcInsuranceCost(BigDecimal coverageAmount, InsuranceType insuranceType) {
        return switch (insuranceType) {
            case MEDICAL -> calculatePriceForInsurance(
                    insuranceProperty.getInsuranceMedicalRate(),
                    coverageAmount,
                    MEDICAL_PAYMENT
            );
            case ROBBERY_PROTECTION -> calculatePriceForInsurance(
                    insuranceProperty.getInsuranceRobberyRate(),
                    coverageAmount,
                    ROBBERY_PAYMENT
            );
            default -> throw new IllegalArgumentException();
        };
    }
}
