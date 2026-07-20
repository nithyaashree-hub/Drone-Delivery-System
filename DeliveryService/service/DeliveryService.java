package com.sfl.deliveryservice.service;

import com.sfl.deliveryservice.dto.DroneDTO;
import com.sfl.deliveryservice.dto.PackageDTO;
import com.sfl.deliveryservice.dto.RouteDTO;
import com.sfl.deliveryservice.entity.Delivery;
import com.sfl.deliveryservice.exception.BadWeatherException;
import com.sfl.deliveryservice.exception.DroneNotAvailableException;
import com.sfl.deliveryservice.exception.LowBatteryException;
import com.sfl.deliveryservice.exception.PackageNotFoundException;
import com.sfl.deliveryservice.exception.RouteNotFoundException;
import com.sfl.deliveryservice.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger =
            LoggerFactory.getLogger(DeliveryService.class);

    // Register Delivery
    public Delivery registerDelivery(Delivery delivery) {

        logger.info("Registering Delivery");

        if (repository.findByDeliveryId(delivery.getDeliveryId()) != null) {

            logger.error("Delivery ID already exists");

            throw new RuntimeException("Delivery ID already exists");
        }

        delivery.setDeliveryStatus("CREATED");

        logger.info("Delivery Registered Successfully");

        return repository.save(delivery);
    }

    // Get All Deliveries
    public List<Delivery> getAllDeliveries() {

        logger.info("Fetching All Deliveries");

        return repository.findAll();
    }

    // Get Delivery By ID
    public Delivery getDeliveryById(int id) {

        logger.info("Fetching Delivery");

        Delivery delivery = repository.findById(id).orElse(null);

        if (delivery == null) {

            logger.error("Delivery Not Found");

            throw new RuntimeException("Delivery Not Found");
        }

        return delivery;
    }

    // Update Delivery
    public Delivery updateDelivery(int id, Delivery delivery) {

        logger.info("Updating Delivery");

        Delivery oldDelivery = repository.findById(id).orElse(null);

        if (oldDelivery == null) {

            logger.error("Delivery Not Found");

            throw new RuntimeException("Delivery Not Found");
        }

        if (repository.findByDeliveryId(delivery.getDeliveryId()) != null &&
                !oldDelivery.getDeliveryId().equals(delivery.getDeliveryId())) {

            logger.error("Delivery ID already exists");

            throw new RuntimeException("Delivery ID already exists");
        }

        oldDelivery.setDeliveryId(delivery.getDeliveryId());
        oldDelivery.setPackageId(delivery.getPackageId());
        oldDelivery.setDroneId(delivery.getDroneId());
        oldDelivery.setDeliveryStatus(delivery.getDeliveryStatus());

        logger.info("Delivery Updated Successfully");

        return repository.save(oldDelivery);
    }

    // Delete Delivery
    public String deleteDelivery(int id) {

        logger.info("Deleting Delivery");

        Delivery delivery = repository.findById(id).orElse(null);

        if (delivery == null) {

            logger.error("Delivery Not Found");

            throw new RuntimeException("Delivery Not Found");
        }

        repository.delete(delivery);

        logger.info("Delivery Deleted Successfully");

        return "Delivery Deleted Successfully";
    }
    // Assign Drone
    public Delivery assignDrone(int id) {

        logger.info("Assigning Drone");

        Delivery delivery = repository.findById(id).orElse(null);

        if (delivery == null) {

            logger.error("Delivery Not Found");

            throw new RuntimeException("Delivery Not Found");
        }

        // Get Drone Details
        DroneDTO drone;

        try {

            drone = restTemplate.getForObject(
                    "http://localhost:8081/api/v1/drones/drone/" + delivery.getDroneId(),
                    DroneDTO.class);

        } catch (Exception e) {

            logger.error("Drone Not Found");

            throw new DroneNotAvailableException("Drone Not Found");
        }

        // Get Package Details
        PackageDTO pack;

        try {
            pack = restTemplate.getForObject(
                    "http://localhost:8082/api/v1/packages/package/" + delivery.getPackageId(),
                    PackageDTO.class);

        } catch (Exception e) {

            logger.error("Package Not Found");

            throw new PackageNotFoundException("Package Not Found");
        }

        // Get Route Details
        RouteDTO route;

        try {
            route = restTemplate.getForObject(
                    "http://localhost:8083/api/v1/routes/package/" + delivery.getPackageId(),
                    RouteDTO.class);

        } catch (Exception e) {

            logger.error("Route Not Found");

            throw new RouteNotFoundException("Route Not Found");
        }

        // Drone Availability
        if (!drone.isAvailable()) {

            logger.error("Drone Not Available");

            updatePackageStatus(pack, "FAILED");

            throw new DroneNotAvailableException("Drone Not Available");
        }

        // Battery Check
        if (drone.getBatteryLevel() < 30) {

            logger.error("Low Battery");

            updatePackageStatus(pack, "FAILED");

            throw new LowBatteryException("Battery level should be at least 30%");
        }

        // Payload Check
        if (pack.getWeight() > drone.getPayloadCapacity()) {

            logger.error("Package exceeds Drone Payload");

            updatePackageStatus(pack, "FAILED");

            throw new RuntimeException("Package exceeds Drone Payload");
        }

        // Weather Check
        if (!route.getWeather().equalsIgnoreCase("CLEAR")) {

            logger.error("Bad Weather");

            updatePackageStatus(pack, "FAILED");

            throw new BadWeatherException(
                    "Delivery cannot be started due to bad weather");
        }

        // Assignment Successful
        delivery.setDeliveryStatus("ASSIGNED");

        updatePackageStatus(pack, "ASSIGNED");

        logger.info("Drone Assigned Successfully");

        return repository.save(delivery);
    }
    // Start Delivery
    public Delivery startDelivery(int id) {

        logger.info("Starting Delivery");

        Delivery delivery = repository.findById(id).orElse(null);

        if (delivery == null) {

            logger.error("Delivery Not Found");

            throw new RuntimeException("Delivery Not Found");
        }

        PackageDTO pack;

        try {

            pack = restTemplate.getForObject(
                    "http://localhost:8082/api/v1/packages/package/" + delivery.getPackageId(),
                    PackageDTO.class);

        } catch (Exception e) {

            logger.error("Package Not Found");

            throw new PackageNotFoundException("Package Not Found");
        }

        delivery.setDeliveryStatus("IN_TRANSIT");

        updatePackageStatus(pack, "IN_TRANSIT");

        logger.info("Delivery Started Successfully");

        return repository.save(delivery);
    }

    // Complete Delivery
    public Delivery completeDelivery(int id) {

        logger.info("Completing Delivery");

        Delivery delivery = repository.findById(id).orElse(null);

        if (delivery == null) {

            logger.error("Delivery Not Found");

            throw new RuntimeException("Delivery Not Found");
        }

        PackageDTO pack;

        try {

            pack = restTemplate.getForObject(
                    "http://localhost:8082/api/v1/packages/package/" + delivery.getPackageId(),
                    PackageDTO.class);

        } catch (Exception e) {

            logger.error("Package Not Found");

            throw new PackageNotFoundException("Package Not Found");
        }

        delivery.setDeliveryStatus("DELIVERED");

        updatePackageStatus(pack, "DELIVERED");

        logger.info("Delivery Completed Successfully");

        return repository.save(delivery);
    }

    // Update Package Status
    private void updatePackageStatus(PackageDTO pack, String status) {

        pack.setStatus(status);

        restTemplate.put(
                "http://localhost:8082/api/v1/packages/package/" + pack.getPackageId(),
                pack);

        logger.info("Package Status Updated to {}", status);
    }

}