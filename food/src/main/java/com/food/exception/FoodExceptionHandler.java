package com.food.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FoodExceptionHandler {

    @ExceptionHandler(value = StockNotAvailableForDealerException.class)
    public ResponseEntity<?> getNoDataExceptionHandler( StockNotAvailableForDealerException ex){
        return new ResponseEntity<>(""+ex.getMessage(), HttpStatusCode.valueOf(ex.getStatuCode()));
    }
}
