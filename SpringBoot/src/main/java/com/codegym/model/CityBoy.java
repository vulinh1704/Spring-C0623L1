package com.codegym.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "city_boy_team",
            joinColumns = {
                   @JoinColumn(name="city_boy_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                   @JoinColumn(name="team_id", referencedColumnName = "id")
            }
    )
    private Set<Team> teams;
}
