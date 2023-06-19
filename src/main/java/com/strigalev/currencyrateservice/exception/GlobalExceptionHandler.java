package com.strigalev.currencyrateservice.exception;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<Object> handle(RestClientException ex, WebRequest request) {
        String message = "Invalid request parameter: abbreviation: " + request.getParameter("abbreviation");

        log.error(message, ex);

        return ResponseEntity.badRequest().body(Map.of("message", message));
    }

    @ExceptionHandler(AbbreviationNotPresentException.class)
    public ResponseEntity<Object> handle(AbbreviationNotPresentException ex) {
        String message = "Required request parameter: abbreviation is empty";

        log.error(message, ex);

        return ResponseEntity.badRequest().body(Map.of("message", message));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handle(IllegalArgumentException ex, WebRequest request) {
        log.error("Illegal Argument exception occurred: {}", ex.getMessage(), ex);

        return handleExceptionInternal(ex, "", new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

}
