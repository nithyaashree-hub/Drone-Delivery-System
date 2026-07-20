package com.sfl.droneservice.exception;

public class DroneNotAvailableException extends RuntimeException {

    public DroneNotAvailableException(String message) {
        super(message);
    }

}