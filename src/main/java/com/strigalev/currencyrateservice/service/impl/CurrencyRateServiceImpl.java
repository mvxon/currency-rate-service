package com.strigalev.currencyrateservice.service.impl;

import com.strigalev.currencyrateservice.domain.CurrencyRate;
import com.strigalev.currencyrateservice.service.CurrencyRateService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

    @Value("${nb-rb.rate-url}")
    private String url;

    private final RestTemplate restTemplate;

    @Override
    public CurrencyRate getCurrencyRateByAbbreviation(String abbreviation) {
        var URL = UriComponentsBuilder.fromUriString(url)
                .uriVariables(Map.of("currencyAbbreviation", abbreviation))
                .queryParam("periodicity", "0")
                .queryParam("parammode", "2")
                .toUriString();

        return restTemplate.getForObject(URL, CurrencyRate.class);
    }
}
