package com.codegym.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CityBoy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;

    @ManyToOne
    private City city;

}
