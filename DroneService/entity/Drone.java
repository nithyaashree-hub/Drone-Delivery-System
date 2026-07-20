package com.sfl.droneservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "drone")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank(message = "Drone ID cannot be empty")
    private String droneId;

    @Min(value = 30, message = "Battery level should be at least 30%")
    @Max(value = 100, message = "Battery level cannot exceed 100%")
    private int batteryLevel;

    @Positive(message = "Payload Capacity should be greater than 0")
    private double payloadCapacity;

    @NotBlank(message = "Current Location cannot be empty")
    private String currentLocation;

    private boolean available;

    public Drone() {
    }

    public Drone(int id, String droneId, int batteryLevel,
                 double payloadCapacity,
                 String currentLocation,
                 boolean available) {
        this.id = id;
        this.droneId = droneId;
        this.batteryLevel = batteryLevel;
        this.payloadCapacity = payloadCapacity;
        this.currentLocation = currentLocation;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDroneId() {
        return droneId;
    }

    public void setDroneId(String droneId) {
        this.droneId = droneId;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}