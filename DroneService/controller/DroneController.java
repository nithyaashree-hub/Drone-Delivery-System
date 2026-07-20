package com.sfl.droneservice.controller;

import com.sfl.droneservice.entity.Drone;
import com.sfl.droneservice.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    private DroneService service;

    // Register Drone
    @PostMapping
    public Drone registerDrone(@Valid @RequestBody Drone drone) {

        return service.registerDrone(drone);

    }

    // Get All Drones
    @GetMapping
    public List<Drone> getAllDrones() {

        return service.getAllDrones();

    }

    @GetMapping("/")
    public String home() {
        return "Drone Service is Running";
    }

    // Get Drone By ID
    @GetMapping("/{id}")
    public Drone getDroneById(@PathVariable int id) {

        return service.getDroneById(id);

    }
    @GetMapping("/drone/{droneId}")
    public Drone getDroneByDroneId(@PathVariable String droneId) {

        return service.getDroneByDroneId(droneId);

    }

    // Update Drone
    @PutMapping("/{id}")
    public Drone updateDrone(@PathVariable int id,
                             @Valid @RequestBody Drone drone) {

        return service.updateDrone(id, drone);

    }

    // Delete Drone
    @DeleteMapping("/{id}")
    public String deleteDrone(@PathVariable int id) {

        return service.deleteDrone(id);

    }

    // Check Drone Availability
    @GetMapping("/check/{id}")
    public Drone checkDrone(@PathVariable int id) {

        return service.checkDrone(id);

    }

}