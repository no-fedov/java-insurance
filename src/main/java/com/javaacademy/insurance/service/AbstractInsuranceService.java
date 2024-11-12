package com.javaacademy.insurance.service;

import com.javaacademy.insurance.config.InsuranceProperty;
import com.javaacademy.insurance.contract.ContractStatus;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.storage.InsuranceArchive;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import static com.javaacademy.insurance.util.InsuranceNumberGenerator.generateInsuranceContractNumber;

@RequiredArgsConstructor
public class AbstractInsuranceService implements InsuranceService {
    private final InsuranceArchive insuranceStorage;
    private final InsuranceCalcService insuranceCalcService;
    private final InsuranceProperty insuranceProperty;

    @Override
    public InsuranceContract insuranceOffer(BigDecimal coverageAmount, String client, InsuranceType insuranceType) {
        String contractNumber = generateInsuranceContractNumber();
        BigDecimal insuranceCost = insuranceCalcService.calcInsuranceCost(coverageAmount, insuranceType);
        InsuranceContract newInsuranceContract = new InsuranceContract(
                contractNumber,
                insuranceCost,
                coverageAmount,
                insuranceProperty.getCurrency(),
                client,
                insuranceProperty.getCountry(),
                insuranceType,
                ContractStatus.UNPAID
        );
        insuranceStorage.saveInsuranceContract(newInsuranceContract);
        return newInsuranceContract;
    }

    @Override
    public InsuranceContract payForInsurance(String insuranceNumber) {
        InsuranceContract insuranceContract = insuranceStorage.findInsuranceContractByNumber(insuranceNumber);
        insuranceContract.setContractStatus(ContractStatus.PAID);
        return insuranceContract;
    }
}
