package com.sfl.droneservice.exception;

public class LowBatteryException extends RuntimeException {

    public LowBatteryException(String message) {
        super(message);
    }

}