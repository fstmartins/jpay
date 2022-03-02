package com.jumia.jpay.service;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.model.CustomerResponseBody;
import com.jumia.jpay.model.State;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseBody> listAll(Country country, State state);
}
