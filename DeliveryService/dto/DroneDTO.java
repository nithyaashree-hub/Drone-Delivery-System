package com.sfl.deliveryservice.dto;

public class DroneDTO {

    private int id;
    private String droneId;
    private int batteryLevel;
    private double payloadCapacity;
    private String currentLocation;
    private boolean available;

    public DroneDTO() {
    }

    public DroneDTO(int id, String droneId, int batteryLevel,
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