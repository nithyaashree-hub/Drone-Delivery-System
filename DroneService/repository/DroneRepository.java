package com.sfl.droneservice.repository;

import com.sfl.droneservice.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {

    Drone findByDroneId(String droneId);

}