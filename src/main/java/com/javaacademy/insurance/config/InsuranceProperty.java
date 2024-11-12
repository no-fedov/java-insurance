package com.javaacademy.insurance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@Getter
@Setter
@ConfigurationProperties(prefix = "app")
public class InsuranceProperty {
    String country;
    String currency;
    BigDecimal insuranceRobberyRate;
    BigDecimal insuranceMedicalRate;
}


