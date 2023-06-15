package com.strigalev.currencyrateservice.controller;


import com.strigalev.currencyrateservice.domain.CurrencyRate;
import com.strigalev.currencyrateservice.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencyRate")
public class CurrencyRateController {
    private final CurrencyRateService currencyRateService;

    @GetMapping("/{abbreviation}")
    public CurrencyRate getById(@PathVariable String abbreviation) {
        return currencyRateService.getCurrencyRateByAbbreviation(abbreviation);
    }
}
