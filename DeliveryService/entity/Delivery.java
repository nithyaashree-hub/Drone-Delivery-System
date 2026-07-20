package com.sfl.deliveryservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank(message = "Delivery ID cannot be empty")
    private String deliveryId;

    @NotBlank(message = "Package ID cannot be empty")
    private String packageId;

    @NotBlank(message = "Drone ID cannot be empty")
    private String droneId;

    private String deliveryStatus;

    public Delivery() {
    }

    public Delivery(int id,
                    String deliveryId,
                    String packageId,
                    String droneId,
                    String deliveryStatus) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.packageId = packageId;
        this.droneId = droneId;
        this.deliveryStatus = deliveryStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId=deliveryId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId=packageId;
    }

    public String getDroneId() {
        return droneId;
    }

    public void setDroneId(String droneId) {
        this.droneId=droneId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus=deliveryStatus;
    }

}