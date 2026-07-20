package com.sfl.deliveryservice.controller;

import com.sfl.deliveryservice.entity.Delivery;
import com.sfl.deliveryservice.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    // Home API
    @GetMapping("/")
    public String home() {
        return "Delivery Service is Running";
    }

    // Register Delivery
    @PostMapping
    public Delivery registerDelivery(@Valid @RequestBody Delivery delivery) {
        return service.registerDelivery(delivery);
    }

    // Get All Deliveries
    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return service.getAllDeliveries();
    }

    // Get Delivery By ID
    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable int id) {
        return service.getDeliveryById(id);
    }

    // Update Delivery
    @PutMapping("/{id}")
    public Delivery updateDelivery(@PathVariable int id,
                                   @Valid @RequestBody Delivery delivery) {
        return service.updateDelivery(id, delivery);
    }

    // Delete Delivery
    @DeleteMapping("/{id}")
    public String deleteDelivery(@PathVariable int id) {
        return service.deleteDelivery(id);
    }

    // Assign Drone
    @PostMapping("/assign/{id}")
    public Delivery assignDrone(@PathVariable int id) {
        return service.assignDrone(id);
    }

    // Start Delivery
    @PutMapping("/{id}/start")
    public Delivery startDelivery(@PathVariable int id) {
        return service.startDelivery(id);
    }

    // Complete Delivery
    @PutMapping("/{id}/complete")
    public Delivery completeDelivery(@PathVariable int id) {
        return service.completeDelivery(id);
    }

}