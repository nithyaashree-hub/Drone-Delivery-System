package com.sfl.deliveryservice.exception;

public class BadWeatherException extends RuntimeException {

    public BadWeatherException(String message) {
        super(message);
    }

}