package com.jumia.jpay.service.impl;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.model.CustomerResponseBody;
import com.jumia.jpay.model.State;
import com.jumia.jpay.repository.CustomerRepository;
import com.jumia.jpay.util.TestsUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    CustomerRepository repository;
    @InjectMocks
    CustomerServiceImpl underTest;

    private List<Customer> mockCustomers;
    private List<CustomerResponseBody> mockCustomerResponseBody;

    @Before
    public void setUp() {
        this.mockCustomers = TestsUtil.getCustomers();
        this.mockCustomerResponseBody = TestsUtil.getCustomerResponseBodies();
    }

    @Test
    public void testListAll() {
        // given
        when(repository.findAll()).thenReturn(this.mockCustomers);

        // when
        List<CustomerResponseBody> customerResponseBodyList = underTest.listAll(null, State.NOT_DEFINED);

        //then
        verify(repository, Mockito.times(1)).findAll();
        Assert.assertEquals(this.mockCustomerResponseBody.size(), customerResponseBodyList.size());
        Assert.assertEquals(this.mockCustomerResponseBody.get(0), customerResponseBodyList.get(0));
        Assert.assertEquals(this.mockCustomerResponseBody.get(1), customerResponseBodyList.get(1));
    }

    @Test
    public void testListAllCountry() {
        // given
        when(repository.findAll()).thenReturn(this.mockCustomers);

        // when
        List<CustomerResponseBody> customerResponseBodyList = underTest.listAll(Country.MOROCCO, State.NOT_DEFINED);

        //then
        verify(repository, Mockito.times(1)).findAll();
        Assert.assertEquals(1, customerResponseBodyList.size());
        Assert.assertEquals(Country.MOROCCO, customerResponseBodyList.get(0).getCountry());
    }

    @Test
    public void testListAllState() {
        // given
        when(repository.findAll()).thenReturn(this.mockCustomers);

        // when
        List<CustomerResponseBody> customerResponseBodyList = underTest.listAll(null, State.VALID);

        //then
        verify(repository, Mockito.times(1)).findAll();
        Assert.assertEquals(1, customerResponseBodyList.size());
        Assert.assertEquals("Valid", customerResponseBodyList.get(0).getState());
    }

    @Test
    public void testListAllCountryAndState() {
        // given
        when(repository.findAll()).thenReturn(this.mockCustomers);

        // when
        List<CustomerResponseBody> customerResponseBodyList = underTest.listAll(Country.MOROCCO, State.NOT_VALID);

        //then
        verify(repository, Mockito.times(1)).findAll();
        Assert.assertEquals(1, customerResponseBodyList.size());
        Assert.assertEquals("Not Valid", customerResponseBodyList.get(0).getState());
        Assert.assertEquals(Country.MOROCCO, customerResponseBodyList.get(0).getCountry());
    }

}
