package com.tuioe.kiosk.controller;

import com.tuioe.kiosk.entity.Product;
import com.tuioe.kiosk.service.KioskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KioskController {

    private final KioskService kioskService;

    @PostMapping("/product")
    public ResponseEntity productAdd(@RequestBody Product product){
        kioskService.ProductCreate(product);
        return new ResponseEntity("생성완료", HttpStatus.CREATED);
    }
}
