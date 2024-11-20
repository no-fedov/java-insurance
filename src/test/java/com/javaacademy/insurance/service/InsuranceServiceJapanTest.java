package com.javaacademy.insurance.service;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.storage.InsuranceArchive;
import com.javaacademy.insurance.util.InsuranceNumberGenerator;
import lombok.Cleanup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static com.javaacademy.insurance.contract.ContractStatus.PAID;
import static com.javaacademy.insurance.contract.ContractStatus.UNPAID;
import static com.javaacademy.insurance.contract.InsuranceType.MEDICAL;
import static com.javaacademy.insurance.contract.InsuranceType.ROBBERY_PROTECTION;
import static java.math.BigDecimal.valueOf;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles({"japan"})
public class InsuranceServiceJapanTest {
    @Autowired
    private InsuranceService insuranceService;

    @MockBean
    private InsuranceArchive insuranceArchive;

    @MockBean
    private InsuranceCalcService insuranceCalcService;

    @Test
    @DisplayName("Получить предложение по страховке от грабежа")
    public void getRobberyInsuranceOfferSuccess() {
        String client = "Иванов Иван Иванович";
        BigDecimal coverageAmount = valueOf(1_000_000);
        InsuranceType insuranceType = ROBBERY_PROTECTION;
        @Cleanup
        var insuranceNumberGeneratorMockedStatic = Mockito.mockStatic(InsuranceNumberGenerator.class);
        Mockito.when(InsuranceNumberGenerator.generateInsuranceContractNumber()).thenReturn("001");
        Mockito.when(insuranceCalcService.calcInsuranceCost(any(), any())).thenReturn(valueOf(20_000));
        InsuranceContract expectedInsuranceContract = new InsuranceContract("001", valueOf(20_000),
                coverageAmount, "yen", client, "Japan", insuranceType, UNPAID);
        InsuranceContract resultInsuranceContract = insuranceService.insuranceOffer(coverageAmount,
                client,
                insuranceType);
        Assertions.assertEquals(expectedInsuranceContract, resultInsuranceContract);
    }

    @Test
    @DisplayName("Получить предложение по медицинской страховке")
    public void getMedicalInsuranceOfferSuccess() {
        String client = "Иванов Иван Иванович";
        BigDecimal coverageAmount = valueOf(10_000_000);
        InsuranceType insuranceType = MEDICAL;
        @Cleanup
        var insuranceNumberGeneratorMockedStatic = Mockito.mockStatic(InsuranceNumberGenerator.class);
        Mockito.when(InsuranceNumberGenerator.generateInsuranceContractNumber()).thenReturn("001");
        Mockito.when(insuranceCalcService.calcInsuranceCost(any(), any())).thenReturn(valueOf(165_000));
        InsuranceContract expectedInsuranceContract = new InsuranceContract("001", valueOf(165_000),
                coverageAmount, "yen", client, "Japan", insuranceType, UNPAID);
        InsuranceContract resultInsuranceContract = insuranceService.insuranceOffer(coverageAmount,
                client,
                insuranceType);
        Assertions.assertEquals(expectedInsuranceContract, resultInsuranceContract);
    }

    @Test
    @DisplayName("Опалата страховки")
    public void payForInsuranceContractSuccess() {
        String insuranceContractNumber = "001";
        InsuranceContract unpaidInsuranceContract = new InsuranceContract(
                insuranceContractNumber,
                valueOf(165_000),
                valueOf(10_000_000),
                "yen",
                "Иванов Иван Иванович",
                "Japan",
                MEDICAL,
                UNPAID
        );
        InsuranceContract expectedInsuranceContract = new InsuranceContract(
                insuranceContractNumber,
                valueOf(165_000),
                valueOf(10_000_000),
                "yen",
                "Иванов Иван Иванович",
                "Japan",
                MEDICAL,
                PAID
        );
        Mockito.when(insuranceArchive.findInsuranceContractByNumber(any())).thenReturn(unpaidInsuranceContract);
        InsuranceContract resultInsuranceContract = insuranceService.payForInsurance(insuranceContractNumber);
        Assertions.assertEquals(expectedInsuranceContract, resultInsuranceContract);
    }
}
