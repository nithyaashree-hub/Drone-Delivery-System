package com.sfl.routeservice.controller;

import com.sfl.routeservice.entity.Route;
import com.sfl.routeservice.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {

    @Autowired
    private RouteService service;
    @GetMapping("/")
    public String home() {

        return "Route Service is Running";

    }
    // Register Route
    @PostMapping
    public Route registerRoute(@Valid @RequestBody Route route) {

        return service.registerRoute(route);
    }

    // Get All Routes
    @GetMapping
    public List<Route> getAllRoutes() {

        return service.getAllRoutes();
    }

    // Get Route By ID
    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable int id) {

        return service.getRouteById(id);
    }

    // Get Route By Package ID
    @GetMapping("/package/{packageId}")
    public Route getRouteByPackageId(@PathVariable String packageId) {

        return service.getRouteByPackageId(packageId);
    }

    // Update Route
    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable int id,
                             @Valid @RequestBody Route route) {

        return service.updateRoute(id, route);
    }

    // Delete Route
    @DeleteMapping("/{id}")
    public String deleteRoute(@PathVariable int id) {

        return service.deleteRoute(id);
    }

}