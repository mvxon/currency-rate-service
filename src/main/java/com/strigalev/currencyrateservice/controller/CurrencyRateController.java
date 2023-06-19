package com.strigalev.currencyrateservice.controller;


import com.strigalev.currencyrateservice.dto.CurrencyRateResponse;
import com.strigalev.currencyrateservice.exception.AbbreviationNotPresentException;
import com.strigalev.currencyrateservice.service.CurrencyRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencyRate")
@Tag(name = "CurrencyRate", description = "Endpoints for currency rate checking")
public class CurrencyRateController {
    private final CurrencyRateService currencyRateService;

    @GetMapping
    @Operation(summary = "Get actual currency rate", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "SUCCESS",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CurrencyRateResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL ERROR", content = @Content)
    })
    public ResponseEntity<CurrencyRateResponse> getById(@RequestParam String abbreviation) {
        if (StringUtils.isBlank(abbreviation)) {
            throw new AbbreviationNotPresentException();
        }
        return ResponseEntity.ok(currencyRateService.getCurrencyRateByAbbreviation(abbreviation));
    }
}
