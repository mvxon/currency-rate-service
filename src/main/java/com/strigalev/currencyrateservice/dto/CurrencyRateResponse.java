package com.strigalev.currencyrateservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record CurrencyRateResponse(
        String currencyAbbreviation,
        String dateOfRequest,
        String currencyName,
        Double actualCurrencyRate
) {

}
