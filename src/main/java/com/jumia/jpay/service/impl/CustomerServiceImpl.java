package com.jumia.jpay.service.impl;

import com.jumia.jpay.model.Customer;
import com.jumia.jpay.repository.CustomerRepository;
import com.jumia.jpay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Customer> filterByCountry() {
        return null;
    }

    @Override
    public List<Customer> filterByState() {
        return null;
    }
}
