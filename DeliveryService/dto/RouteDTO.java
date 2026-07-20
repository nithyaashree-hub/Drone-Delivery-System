package com.sfl.deliveryservice.dto;

public class RouteDTO {

    private int id;
    private String packageId;
    private String source;
    private String destination;
    private String routePath;
    private double distance;
    private String weather;

    public RouteDTO() {
    }

    public RouteDTO(int id,
                    String packageId,
                    String source,
                    String destination,
                    String routePath,
                    double distance,
                    String weather) {

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