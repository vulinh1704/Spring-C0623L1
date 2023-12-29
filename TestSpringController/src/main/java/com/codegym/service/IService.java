package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    int findById(Long id);

    void add(E e);

    void edit(Long id, Customer customer);


    void delete(Long id);

    E findCustomerById(Long id);
}
