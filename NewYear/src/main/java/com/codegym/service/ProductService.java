package com.codegym.service;

import java.util.List;

public interface ProductService<E> {
    void save(E e);
    void delete(Long id);
    List<E> findAll();
    E findById(Long id);
    List<E> findByName(String name);
}
