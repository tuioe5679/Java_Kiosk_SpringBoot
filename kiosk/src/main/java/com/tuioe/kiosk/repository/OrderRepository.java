package com.tuioe.kiosk.repository;

import com.tuioe.kiosk.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
