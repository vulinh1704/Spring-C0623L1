package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IService<Customer> {
    private List<Customer> customerList = new ArrayList<>();

    public CustomerService() {
        customerList.add(new Customer(1, "Linh"));
        customerList.add(new Customer(2, "De an cut"));
        customerList.add(new Customer(3, "Hieu"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void delete(int id) {
        int index = findById(id);
        customerList.remove(index);
    }

    @Override
    public void edit(int id, Customer customer) {
        int index = findById(id);
        customerList.set(index, customer);
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (id == customerList.get(i).getId()) return i;
        }
        return -1;
    }

    @Override
    public Customer findElementById(int id) {
        for (Customer c : customerList) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}
