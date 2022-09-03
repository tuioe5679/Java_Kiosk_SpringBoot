package com.tuioe.kiosk.controller;

import com.tuioe.kiosk.entity.Product;
import com.tuioe.kiosk.service.KioskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KioskController {

    private final KioskService kioskService;

    @GetMapping("/product/all")
    public List<Product> findProductList(){
        return kioskService.findAllProduct();
    }
}
