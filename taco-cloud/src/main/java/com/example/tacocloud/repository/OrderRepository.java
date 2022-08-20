package com.example.tacocloud.repository;

import com.example.tacocloud.model.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
