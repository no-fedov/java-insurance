package com.javaacademy.insurance.service.impl.japan;

import com.javaacademy.insurance.config.InsuranceProperty;
import com.javaacademy.insurance.service.AbstractInsuranceService;
import com.javaacademy.insurance.service.InsuranceCalcService;
import com.javaacademy.insurance.storage.InsuranceArchive;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("japan")
public class InsuranceServiceJapan extends AbstractInsuranceService {

    public InsuranceServiceJapan(InsuranceArchive insuranceStorage,
                                 InsuranceCalcService insuranceCalcService,
                                 InsuranceProperty insuranceProperty) {
        super(insuranceStorage, insuranceCalcService, insuranceProperty);
    }

}
