package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerService implements IService<Customer> {
    private List<Customer> customerList = new ArrayList<>();

    public CustomerService() {
        customerList.add(new Customer(1L, "Ning"));
        customerList.add(new Customer(2L, "Hieu"));
        customerList.add(new Customer(3L, "Dan"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public int findById(Long id) {
        for (int i = 0; i < customerList.size(); i++) {
            if(Objects.equals(id, customerList.get(i).getId())) return i;
        }
        return -1;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void edit(Long id, Customer customer) {
        int index = findById(id);
        customerList.set(index, customer);
    }

    @Override
    public void delete(Long id) {
        int index = findById(id);
        customerList.remove(index);
    }

    public Customer findCustomerById(Long id) {
        for (Customer c: customerList) {
            if(c.getId() == id ){
                return c;
            }
        }
        return null;
    }
}
