package com.tuioe.kiosk.entity;

import lombok.Data;
import javax.persistence.*;

@Table(name = "member")
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(nullable = false,length = 10)
    private String id;

    @Column(nullable = false,length = 15)
    private String pwd;

    @Column(nullable = false,length = 5)
    private String name;

    @Column(nullable = false)
    private int totalmoney;
}
