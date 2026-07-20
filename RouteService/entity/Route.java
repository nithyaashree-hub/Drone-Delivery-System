package com.sfl.routeservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Package ID cannot be empty")
    @Column(unique = true)
    private String packageId;

    @NotBlank(message = "Source cannot be empty")
    private String source;

    @NotBlank(message = "Destination cannot be empty")
    private String destination;

    @NotBlank(message = "Route Path cannot be empty")
    private String routePath;

    @Positive(message = "Distance should be greater than 0")
    private double distance;

    @NotBlank(message = "Weather cannot be empty")
    private String weather;

    public Route() {
    }

    public Route(int id, String packageId, String source,
                 String destination, String routePath,
                 double distance, String weather) {
        this.id = id;
        this.packageId = packageId;
        this.source = source;
        this.destination = destination;
        this.routePath = routePath;
        this.distance = distance;
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRoutePath() {
        return routePath;
    }

    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}