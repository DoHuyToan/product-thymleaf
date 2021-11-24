package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(int id);

    void edit(int id, Customer customer);

    void remove(int id);

    Customer findByName(String name);
}
