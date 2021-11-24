package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customerList;

    static {
        customerList = new HashMap<>();
        customerList.put(1, new Customer(1, "Bằng", "bang@mail", "Hải Dương"));
        customerList.put(2, new Customer(2, "Định", "dinh@mail", "Nam Định"));
        customerList.put(3, new Customer(3, "Thảo", "thao@mail", "Phú Thọ"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void create(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void edit(int id, Customer customer) {
        customerList.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }

    @Override
    public Customer findByName(String name) {
        return null;
    }
}
