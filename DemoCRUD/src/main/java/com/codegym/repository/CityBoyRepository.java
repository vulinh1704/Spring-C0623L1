package com.codegym.repository;

import java.util.List;

public interface CityBoyRepository<E>{
    List<E> findAll();
    void save(E e);
    void delete(Long id);
    E findById(Long id);
}
