package com.tuioe.kiosk.repository;

import com.tuioe.kiosk.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
