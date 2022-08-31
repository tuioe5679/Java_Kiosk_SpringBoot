package com.tuioe.kiosk.entity;

import lombok.Data;
import javax.persistence.*;

@Table(name = "orders")
@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int count;
}
