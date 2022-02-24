package com.jumia.jpay.service.impl;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.repository.CustomerRepository;
import com.jumia.jpay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;
    
    @Override
    public List<Customer> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Customer> filterByCountry(Country country) {
        List<Customer> customers = repository.findAll();
        List<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer: customers) {
            if (customer.getPhone().matches(country.prefix)) {
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }

    @Override
    public List<Customer> filterByState() {
        return null;
    }
}
