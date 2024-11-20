package com.javaacademy.insurance.service.calc;

import com.javaacademy.insurance.service.InsuranceCalcService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static com.javaacademy.insurance.contract.InsuranceType.MEDICAL;
import static com.javaacademy.insurance.contract.InsuranceType.ROBBERY_PROTECTION;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"brazil"})
public class InsuranceCalcBrazilServiceTest {
    @Autowired
    private InsuranceCalcService insuranceCalcService;

    @Test
    @DisplayName("Расчет стоимости страховки при грабеже")
    public void calculateCostRobberyInsurance() {
        BigDecimal coverageAmount = BigDecimal.valueOf(50_000);
        BigDecimal result = insuranceCalcService.calcInsuranceCost(coverageAmount, ROBBERY_PROTECTION);
        BigDecimal expected = BigDecimal.valueOf(2_800);

        assertEquals(0, expected.compareTo(result));
    }

    @Test
    @DisplayName("Расчет стоимости медстраховки")
    public void calculateCostMedicalInsurance() {
        BigDecimal coverageAmount = BigDecimal.valueOf(200_000);
        BigDecimal result = insuranceCalcService.calcInsuranceCost(coverageAmount, MEDICAL);
        BigDecimal expected = BigDecimal.valueOf(6_800);

        assertEquals(0, expected.compareTo(result));
    }
}
