package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface ICityBoyService<E>{
    void save(E e);
    void delete(Long id);
    List<E> findAll();
    Optional<E> findById(Long id);
    List<E> findByAgeCityBoy(int age);
    List<E> findByNameContaining(String name);
    E findCustom(String name, int age);
    List<E> findByTeamsId(Long id);
}
