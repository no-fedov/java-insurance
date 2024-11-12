package com.javaacademy.insurance.contract;

import lombok.Getter;

@Getter
public enum InsuranceType {
    MEDICAL("Медицинская страховка"),
    ROBBERY_PROTECTION("Страховка от грабежа");

    private final String description;

    InsuranceType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return '\"' + description + '\"';
    }
}
