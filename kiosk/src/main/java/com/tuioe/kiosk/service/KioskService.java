package com.tuioe.kiosk.service;

import com.tuioe.kiosk.entity.Product;
import com.tuioe.kiosk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KioskService {

    private final ProductRepository productRepository;

    public void createProduct(Product product){
        productRepository.save(product);
    }

}
