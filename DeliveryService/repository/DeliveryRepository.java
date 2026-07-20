package com.sfl.deliveryservice.repository;

import com.sfl.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    Delivery findByDeliveryId(String deliveryId);

}
