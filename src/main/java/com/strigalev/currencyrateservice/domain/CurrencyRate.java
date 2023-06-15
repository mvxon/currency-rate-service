package com.strigalev.currencyrateservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {

    @JsonProperty("Cur_ID")
    private Long currencyId;

    @JsonProperty("Date")
    private String dateOfRequest;

    @JsonProperty("Cur_Abbreviation")
    private String currencyAbbreviation;

    @JsonProperty("Cur_Name")
    private String currencyName;

    @JsonProperty("Cur_OfficialRate")
    private Double officialRate;
}
