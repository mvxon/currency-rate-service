# ****CURRENCY RATE SERVICE****
### Service with ability to check actual currency rate according to different countries central banks
One service instance can represent currency rate of one country central bank.

To choose the country change `profile` property in `application.yml`
```yaml
spring:
  profiles:
    active: ${BANK_PROFILE:example}
```
Then you should implement `CurrencyRateService` interface.

And make sure you are added suitable `application-example.yml` file into the resources with URL declaration:
```yaml
bank-service:
  url: ${BANK_API_URL:https://api.nbrb.by/exrates/rates/{currencyAbbreviation}}
```
