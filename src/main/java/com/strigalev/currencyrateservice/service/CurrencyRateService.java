package com.strigalev.currencyrateservice.service;


import com.strigalev.currencyrateservice.dto.CurrencyRateResponse;

public interface CurrencyRateService {

    /**
     * Get actual currency rate by currency abbreviation
     *
     * @param abbreviation {@link String}
     * @return {@link CurrencyRateResponse}
     */
    CurrencyRateResponse getCurrencyRateByAbbreviation(String abbreviation);
}
