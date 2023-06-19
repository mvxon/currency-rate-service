package com.strigalev.currencyrateservice.config;

import com.strigalev.currencyrateservice.exception.AbbreviationNotPresentException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RestClientException.class, AbbreviationNotPresentException.class})
    public ResponseEntity<Object> handle(Exception ex, WebRequest request) {
        String message = ex.getClass().equals(AbbreviationNotPresentException.class)
                ? "Required request parameter: abbreviation is empty"
                : "Invalid request parameter: abbreviation: " + request.getParameter("abbreviation");

        log.error(message, ex);

        return ResponseEntity.badRequest().body(Map.of("message", message));
    }
}
