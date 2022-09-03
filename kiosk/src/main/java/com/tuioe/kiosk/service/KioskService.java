package com.tuioe.kiosk.service;

import com.tuioe.kiosk.entity.Product;
import com.tuioe.kiosk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KioskService {

    private final ProductRepository productRepository;

    public List<Product> findAllProduct(){
        List<Product> productList =  productRepository.findAll();
        return productList;
    }

}
