package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Table(name="city_boy_c06")
public class CityBoy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Size(min = 6, max = 10, message = "Độ dài 6 - 10 ký tự")
    private String name;
    @Min(value = 18, message = "18 tuổi trở lên")
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Nhập theo định dang test@gmail.com")
    private String email;

    @ManyToOne
    private City city;

    public CityBoy() {
    }

    public CityBoy(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public CityBoy(Long id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public CityBoy(Long id, String name, int age, String email, City city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
