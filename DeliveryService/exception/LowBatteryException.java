package com.sfl.deliveryservice.exception;

public class LowBatteryException extends RuntimeException {

    public LowBatteryException(String message) {
        super(message);
    }

}