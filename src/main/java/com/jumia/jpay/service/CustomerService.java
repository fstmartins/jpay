package com.jumia.jpay.service;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAll();
    List<Customer> filterByCountry(Country country);
    List<Customer> filterByState();
}
