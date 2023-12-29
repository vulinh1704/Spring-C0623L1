package com.codegym.service;

import java.util.List;

public interface IService<E>{
    List<E> findAll();
    void add(E e);
    void delete(int id);
    void edit(int id, E e);
    int findById(int id);
    E findElementById(int id);
}
