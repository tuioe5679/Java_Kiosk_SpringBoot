package com.tuioe.kiosk.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "product")
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String image;
}
