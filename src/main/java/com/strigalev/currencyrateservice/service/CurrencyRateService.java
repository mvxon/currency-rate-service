package com.strigalev.currencyrateservice.service;


import com.strigalev.currencyrateservice.domain.CurrencyRate;

public interface CurrencyRateService {
    CurrencyRate getCurrencyRateByAbbreviation(String id);
}
