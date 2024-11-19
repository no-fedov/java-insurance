package com.javaacademy.insurance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@Getter
@Setter
@ConfigurationProperties(prefix = "app")
public class InsuranceProperty {
    private String country;
    private String currency;
    private BigDecimal insuranceRobberyRate;
    private BigDecimal insuranceMedicalRate;
}
