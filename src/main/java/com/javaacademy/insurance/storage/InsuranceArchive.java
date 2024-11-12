package com.javaacademy.insurance.storage;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InsuranceArchive {
    private final Map<String, InsuranceContract> insuranceStorage = new HashMap<>();

    public void saveInsuranceContract(InsuranceContract contract) {
        insuranceStorage.put(contract.getNumber(), contract);
    }

    public InsuranceContract findInsuranceContractByNumber(String number) {
        return Optional.ofNullable(insuranceStorage.get(number))
                .orElseThrow(() -> new NotFoundException("Такого договора несуществует"));
    }
}
