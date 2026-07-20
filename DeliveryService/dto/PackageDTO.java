package com.sfl.deliveryservice.dto;

public class PackageDTO {

    private int id;
    private String packageId;
    private String packageName;
    private String sender;
    private String receiver;
    private double weight;
    private String destination;
    private String status;

    public PackageDTO() {
    }

    public PackageDTO(int id, String packageId, String packageName,
                      String sender, String receiver,
                      double weight, String destination,
                      String status) {

        this.id = id;
        this.packageId = packageId;
        this.packageName = packageName;
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.destination = destination;
        this.status = status;
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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}