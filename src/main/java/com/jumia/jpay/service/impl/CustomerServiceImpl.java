package com.jumia.jpay.service.impl;

import com.jumia.jpay.mapper.CustomerToCustomerResponseMapper;
import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.model.CustomerResponseBody;
import com.jumia.jpay.model.State;
import com.jumia.jpay.repository.CustomerRepository;
import com.jumia.jpay.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    private static final String VALID = "Valid";
    private static final String NOT_VALID = "Not Valid";

    @Override
    public List<CustomerResponseBody> listAll(Country country, State state) {
        log.debug("CustomerServiceImpl.listAll()");
        List<Customer> customerList = repository.findAll();
        if (Objects.isNull(country) && State.NOT_DEFINED.equals(state)) {
            return prepareCustomerResponse(customerList);
        }
        if (Objects.isNull(country)) {
            return filterByState(customerList, state);
        }
        if (state.equals(State.NOT_DEFINED)) {
            return filterByCountry(customerList, country);
        }
        return filterByStateAndCountry(customerList, state, country);
    }

    private List<CustomerResponseBody> filterByStateAndCountry(List<Customer> customers, State state, Country country) {
        log.debug("CustomerServiceImpl.filterByStateAndCountry()");
        List<CustomerResponseBody> filteredByCountry = filterByCountry(customers, country);
        List<CustomerResponseBody> responseList = new LinkedList<>();
        if (State.VALID.equals(state)) {
            for (CustomerResponseBody customer : filteredByCountry) {
                if (VALID.equalsIgnoreCase(customer.getState())) {
                    responseList.add(customer);
                }
            }
        } else {
            for (CustomerResponseBody customer : filteredByCountry) {
                if (NOT_VALID.equalsIgnoreCase(customer.getState())) {
                    responseList.add(customer);
                }
            }
        }
        log.debug("CustomerServiceImpl: filter by state and country, returning: {}", responseList);
        return responseList;
    }

    private List<CustomerResponseBody> prepareCustomerResponse(List<Customer> customerList) {
        log.debug("CustomerServiceImpl.prepareCustomerResponse()");
        List<CustomerResponseBody> customerResponseBodyList = new LinkedList<>();
        for (Customer customer : customerList) {
            CustomerResponseBody customerResponseBody = CustomerToCustomerResponseMapper.INSTANCE.customerToCustomerResponse(customer);
            setStateAndCountry(customerResponseBody);
            customerResponseBodyList.add(customerResponseBody);
        }
        log.debug("CustomerServiceImpl: prepare customer response, returning: {}", customerResponseBodyList);
        return customerResponseBodyList;
    }

    private void setStateAndCountry(CustomerResponseBody customerResponseBody) {
        log.debug("CustomerServiceImpl.setStateAndCountry()");
        List<Country> countries = Arrays.asList(Country.values());
        Optional<Country> country = countries.stream().
                filter(c -> customerResponseBody.getPhone().split(" ")[0].equalsIgnoreCase(c.countryCode))
                .findFirst();


        if (country.isPresent()) {
            log.debug("CustomerServiceImpl: set state and country: country found: {}", country.get());
            customerResponseBody.setCountry(country.get());
            customerResponseBody.setState(customerResponseBody.getPhone().matches(country.get().regex) ? VALID : NOT_VALID);
        }
        log.debug("CustomerServiceImpl: setting state as {} and country as {}", customerResponseBody.getState(), customerResponseBody.getCountry());
    }

    private List<CustomerResponseBody> filterByCountry(List<Customer> customers, Country country) {
        log.debug("CustomerServiceImpl.filterByCountry()");
        List<CustomerResponseBody> filteredCustomers = new LinkedList<>();
        for (Customer customer : customers) {
            String[] split = customer.getPhone().split(" ");
            String prefix = split[0];
            if (prefix.equalsIgnoreCase(country.countryCode)) {
                CustomerResponseBody customerResponseBody = CustomerToCustomerResponseMapper.INSTANCE.customerToCustomerResponse(customer);
                customerResponseBody.setState(customer.getPhone().matches(country.regex) ? VALID : NOT_VALID);
                customerResponseBody.setCountry(country);
                filteredCustomers.add(customerResponseBody);
            }
        }
        log.debug("CustomerServiceImpl: filter by country, returning: {}", filteredCustomers);
        return filteredCustomers;
    }

    private List<CustomerResponseBody> filterByState(List<Customer> customers, State state) {
        log.debug("CustomerServiceImpl.filterByState()");
        if (state.equals(State.NOT_DEFINED)) {
            log.debug("CustomerServiceImpl: filter by state: state is not defined");
            List<CustomerResponseBody> allCustomers = new LinkedList<>();
            for (Customer customer : customers) {
                CustomerResponseBody customerResponseBody = CustomerToCustomerResponseMapper.INSTANCE.customerToCustomerResponse(customer);
                setStateAndCountry(customerResponseBody);
                allCustomers.add(customerResponseBody);
            }
            log.debug("CustomerServiceImpl: filter by state, returning: {}", allCustomers);
            return allCustomers;
        }

        List<Country> countries = Arrays.asList(Country.values());
        List<CustomerResponseBody> validCustomers = new LinkedList<>();
        List<CustomerResponseBody> invalidCustomers = new LinkedList<>();
        for (Customer customer : customers) {
            Optional<Country> countryOptional = countries.stream()
                    .filter(country -> customer.getPhone().matches(country.regex))
                    .findAny();
            CustomerResponseBody customerResponseBody = CustomerToCustomerResponseMapper.INSTANCE.customerToCustomerResponse(customer);
            if (countryOptional.isPresent()) {
                customerResponseBody.setState(VALID);
                customerResponseBody.setCountry(countryOptional.get());
                validCustomers.add(customerResponseBody);
            } else {
                customerResponseBody.setState(NOT_VALID);
                invalidCustomers.add(customerResponseBody);
            }
        }
        log.info("CustomerServiceImpl: filter by state, returning valid or invalid customers");
        return state.equals(State.VALID) ? validCustomers : invalidCustomers;
    }
}
