package com.sfl.routeservice.repository;

import com.sfl.routeservice.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Integer> {

    Route findByPackageId(String packageId);

}