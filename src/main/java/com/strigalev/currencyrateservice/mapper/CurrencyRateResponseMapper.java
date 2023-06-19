package com.strigalev.currencyrateservice.mapper;

import com.strigalev.currencyrateservice.domain.CurrencyRateNBRB;
import com.strigalev.currencyrateservice.dto.CurrencyRateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CurrencyRateResponseMapper {

    CurrencyRateResponse map(CurrencyRateNBRB currencyRateNbRb);
}
