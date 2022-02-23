package com.jumia.jpay.service;

import com.jumia.jpay.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAll();
    List<Customer> filterByCountry();
    List<Customer> filterByState();
}
