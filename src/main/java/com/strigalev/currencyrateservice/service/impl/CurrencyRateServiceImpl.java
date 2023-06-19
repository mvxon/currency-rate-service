package com.strigalev.currencyrateservice.service.impl;

import com.strigalev.currencyrateservice.config.properties.BankUrlProperties;
import com.strigalev.currencyrateservice.domain.CurrencyRateNBRB;
import com.strigalev.currencyrateservice.dto.CurrencyRateResponse;
import com.strigalev.currencyrateservice.exception.AbbreviationNotPresentException;
import com.strigalev.currencyrateservice.mapper.CurrencyRateResponseMapper;
import com.strigalev.currencyrateservice.service.CurrencyRateService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.strigalev.currencyrateservice.util.ApplicationConstants.NB_RB;

@Service
@Profile(NB_RB)
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {
    private final BankUrlProperties bankUrlProperties;
    private final RestTemplate restTemplate;
    private final CurrencyRateResponseMapper responseMapper;

    @Override
    public CurrencyRateResponse getCurrencyRateByAbbreviation(String abbreviation) {
        if (StringUtils.isBlank(abbreviation)) {
            throw new AbbreviationNotPresentException();
        }
        var URL = UriComponentsBuilder.fromUriString(bankUrlProperties.url())
                .uriVariables(Map.of("currencyAbbreviation", abbreviation))
                .queryParam("periodicity", "0")
                .queryParam("parammode", "2")
                .toUriString();

        var serviceResponse = restTemplate.getForObject(URL, CurrencyRateNBRB.class);

        return responseMapper.map(serviceResponse);
    }
}
