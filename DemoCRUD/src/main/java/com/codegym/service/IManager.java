package com.codegym.service;

import java.util.List;

public interface IManager<E>{
    void add(E e);
    void edit(int id, E e);
    void delete(int id);
    List<E> findAll();
    int findById(int id);
    E findElementById(int id);
}
