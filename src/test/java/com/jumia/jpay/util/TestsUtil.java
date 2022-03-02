package com.jumia.jpay.util;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.model.CustomerResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TestsUtil {

    private static List<Customer> customers = null;
    private static List<CustomerResponseBody> customerResponseBodies = null;
    private static final String MOCK_NAME_1 = "MOCK1";
    private static final String MOCK_NAME_2 = "MOCK2";
    private static final String MOCK_NUMBER_1 = "(258) 823747618";
    private static final String MOCK_NUMBER_2 = "(212) 6546545369";

    public static List<Customer> getCustomers(){
        if (Objects.isNull(customers)){
            Customer customer1 = new Customer();
            customer1.setId(1);
            customer1.setName(MOCK_NAME_1);
            customer1.setPhone(MOCK_NUMBER_1);

            Customer customer2 = new Customer();
            customer2.setId(2);
            customer2.setName(MOCK_NAME_2);
            customer2.setPhone(MOCK_NUMBER_2);

            customers = new LinkedList<>();
            customers.add(customer1);
            customers.add(customer2);
        }
        return customers;
    }

    public static List<CustomerResponseBody> getCustomerResponseBodies(){
        if (Objects.isNull(customerResponseBodies)){
            CustomerResponseBody customer1 = new CustomerResponseBody();
            customer1.setId(1);
            customer1.setName(MOCK_NAME_1);
            customer1.setPhone(MOCK_NUMBER_1);
            customer1.setCountry(Country.MOZAMBIQUE);
            customer1.setState("Valid");

            CustomerResponseBody customer2 = new CustomerResponseBody();
            customer2.setId(2);
            customer2.setName(MOCK_NAME_2);
            customer2.setPhone(MOCK_NUMBER_2);
            customer2.setCountry(Country.MOROCCO);
            customer2.setState("Not Valid");

            customerResponseBodies = new LinkedList<>();
            customerResponseBodies.add(customer1);
            customerResponseBodies.add(customer2);
        }
        return customerResponseBodies;
    }
}
