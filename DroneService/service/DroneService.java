package com.sfl.droneservice.service;

import com.sfl.droneservice.entity.Drone;
import com.sfl.droneservice.exception.DroneNotAvailableException;
import com.sfl.droneservice.exception.LowBatteryException;
import com.sfl.droneservice.repository.DroneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    @Autowired
    private DroneRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(DroneService.class);

    // Register Drone
    public Drone registerDrone(Drone drone) {

        logger.info("Registering Drone");

        if (repository.findByDroneId(drone.getDroneId()) != null) {

            logger.error("Drone ID already exists");

            throw new RuntimeException("Drone ID already exists");
        }

        logger.info("Drone Registered Successfully");

        return repository.save(drone);
    }

    // Get All Drones
    public List<Drone> getAllDrones() {

        logger.info("Fetching All Drones");

        return repository.findAll();
    }

    // Get Drone By ID
    public Drone getDroneById(int id) {

        logger.info("Fetching Drone with ID {}", id);

        Drone drone = repository.findById(id).orElse(null);

        if (drone == null) {

            logger.error("Drone Not Found");

            throw new DroneNotAvailableException("Drone Not Found");
        }

        return drone;
    }
    public Drone getDroneByDroneId(String droneId) {

        Drone drone = repository.findByDroneId(droneId);

        if (drone == null) {
            throw new DroneNotAvailableException("Drone Not Found");
        }

        return drone;
    }
    // Update Drone
    public Drone updateDrone(int id, Drone drone) {

        logger.info("Updating Drone with ID {}", id);

        Drone oldDrone = repository.findById(id).orElse(null);

        if (oldDrone == null) {

            logger.error("Drone Not Found");

            throw new DroneNotAvailableException("Drone Not Found");
        }

        Drone duplicateDrone = repository.findByDroneId(drone.getDroneId());

        if (duplicateDrone != null && duplicateDrone.getId() != id) {

            logger.error("Drone ID already exists");

            throw new RuntimeException("Drone ID already exists");
        }

        oldDrone.setDroneId(drone.getDroneId());
        oldDrone.setBatteryLevel(drone.getBatteryLevel());
        oldDrone.setPayloadCapacity(drone.getPayloadCapacity());
        oldDrone.setCurrentLocation(drone.getCurrentLocation());
        oldDrone.setAvailable(drone.isAvailable());

        logger.info("Drone Updated Successfully");

        return repository.save(oldDrone);
    }

    // Delete Drone
    public String deleteDrone(int id) {

        logger.info("Deleting Drone with ID {}", id);

        Drone drone = repository.findById(id).orElse(null);

        if (drone == null) {

            logger.error("Drone Not Found");

            throw new DroneNotAvailableException("Drone Not Found");
        }

        repository.delete(drone);

        logger.info("Drone Deleted Successfully");

        return "Drone Deleted Successfully";
    }

    // Check Drone Availability
    public Drone checkDrone(int id) {

        logger.info("Checking Drone Availability");

        Drone drone = repository.findById(id).orElse(null);

        if (drone == null) {

            logger.error("Drone Not Found");

            throw new DroneNotAvailableException("Drone Not Found");
        }

        if (!drone.isAvailable()) {

            logger.error("Drone Not Available");

            throw new DroneNotAvailableException("Drone is not available");
        }

        if (drone.getBatteryLevel() < 30) {

            logger.error("Low Battery");

            throw new LowBatteryException("Battery level should be at least 30%");
        }

        logger.info("Drone is Ready for Delivery");

        return drone;
    }

}