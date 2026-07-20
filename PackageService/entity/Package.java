package com.sfl.packageservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "package_details")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank(message = "Package ID cannot be empty")
    private String packageId;

    @NotBlank(message = "Package Name cannot be empty")
    private String packageName;

    @Positive(message = "Weight should be greater than 0")
    private double weight;
    @NotBlank(message = "Sender cannot be empty")
    private String sender;

    @NotBlank(message = "Receiver cannot be empty")
    private String receiver;

    @NotBlank(message = "Destination cannot be empty")
    private String destination;
    private String status;

    public Package() {
    }

    public Package(int id, String packageId, String packageName,
                   double weight, String destination, String status) {
        this.id = id;
        this.packageId = packageId;
        this.packageName = packageName;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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