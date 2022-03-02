package com.jumia.jpay.rest;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.CustomerResponseBody;
import com.jumia.jpay.model.State;
import com.jumia.jpay.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    CustomerServiceImpl phoneNumberService;
    @InjectMocks
    CustomerController underTest;


    @Test
    public void controllerTestTwoArgs() {
        // given
        CustomerResponseBody customerResponseBody = new CustomerResponseBody();
        customerResponseBody.setState("Valid");
        customerResponseBody.setCountry(Country.CAMEROON);
        when(phoneNumberService.listAll(any(Country.class), any(State.class))).thenReturn(Collections.<CustomerResponseBody>singletonList(customerResponseBody));

        // when
        List<CustomerResponseBody> result = underTest.getAllNumbers(Country.CAMEROON, State.VALID);

        // then
        verify(phoneNumberService, times(1)).listAll(Country.CAMEROON, State.VALID);
        Assert.assertEquals(Collections.<CustomerResponseBody>singletonList(customerResponseBody), result);
        Assert.assertEquals(Country.CAMEROON, result.get(0).getCountry());
        Assert.assertEquals("Valid", result.get(0).getState());
    }

    @Test
    public void controllerTestCountryNull() {
        // given
        CustomerResponseBody customerResponseBody = new CustomerResponseBody();
        customerResponseBody.setCountry(null);
        when(phoneNumberService.listAll(any(null), any(State.class))).thenReturn(Collections.<CustomerResponseBody>singletonList(customerResponseBody));

        // when
        List<CustomerResponseBody> result = underTest.getAllNumbers(null, State.NOT_DEFINED);

        // then
        verify(phoneNumberService, times(1)).listAll(null, State.NOT_DEFINED);
        Assert.assertNull(result.get(0).getCountry());
    }
}
