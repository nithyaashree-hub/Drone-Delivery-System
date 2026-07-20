package com.sfl.routeservice.service;

import com.sfl.routeservice.entity.Route;
import com.sfl.routeservice.exception.BadWeatherException;
import com.sfl.routeservice.exception.RouteNotFoundException;
import com.sfl.routeservice.repository.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(RouteService.class);

    // Register Route
    public Route registerRoute(Route route) {

        logger.info("Registering Route");

        if (repository.findByPackageId(route.getPackageId()) != null) {

            logger.error("Package ID already exists");

            throw new RuntimeException("Package ID already exists");
        }

        if (route.getDistance() > 20) {

            logger.error("Distance exceeds drone range");

            throw new RuntimeException("Distance exceeds drone range");
        }

        if (!route.getWeather().equals("CLEAR")) {

            logger.error("Bad Weather");

            throw new BadWeatherException("Weather must be CLEAR");
        }

        logger.info("Route Registered Successfully");

        return repository.save(route);
    }

    // Get All Routes
    public List<Route> getAllRoutes() {

        logger.info("Fetching All Routes");

        return repository.findAll();
    }

    // Get Route By ID
    public Route getRouteById(int id) {

        logger.info("Fetching Route with ID {}", id);

        Route route = repository.findById(id).orElse(null);

        if (route == null) {

            logger.error("Route Not Found");

            throw new RouteNotFoundException("Route Not Found");
        }

        return route;
    }

    // Get Route By Package ID
    public Route getRouteByPackageId(String packageId) {

        logger.info("Fetching Route using Package ID {}", packageId);

        Route route = repository.findByPackageId(packageId);

        if (route == null) {

            logger.error("Route Not Found");

            throw new RouteNotFoundException("Route Not Found");
        }

        return route;
    }

    // Update Route
    public Route updateRoute(int id, Route route) {

        logger.info("Updating Route with ID {}", id);

        Route oldRoute = repository.findById(id).orElse(null);

        if (oldRoute == null) {

            logger.error("Route Not Found");

            throw new RouteNotFoundException("Route Not Found");
        }

        if (route.getDistance() > 20) {

            logger.error("Distance exceeds drone range");

            throw new RuntimeException("Distance exceeds drone range");
        }

        if (!route.getWeather().equals("CLEAR")) {

            logger.error("Bad Weather");

            throw new BadWeatherException("Weather must be CLEAR");
        }

        oldRoute.setPackageId(route.getPackageId());
        oldRoute.setSource(route.getSource());
        oldRoute.setDestination(route.getDestination());
        oldRoute.setRoutePath(route.getRoutePath());
        oldRoute.setDistance(route.getDistance());
        oldRoute.setWeather(route.getWeather());

        logger.info("Route Updated Successfully");

        return repository.save(oldRoute);
    }

    // Delete Route
    public String deleteRoute(int id) {

        logger.info("Deleting Route with ID {}", id);

        Route route = repository.findById(id).orElse(null);

        if (route == null) {

            logger.error("Route Not Found");

            throw new RouteNotFoundException("Route Not Found");
        }

        repository.delete(route);

        logger.info("Route Deleted Successfully");

        return "Route Deleted Successfully";
    }

}