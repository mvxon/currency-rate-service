package com.strigalev.currencyrateservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "bank-service")
public record BankUrlProperties(String url) {
}
