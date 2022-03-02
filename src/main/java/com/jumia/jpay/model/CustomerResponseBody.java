package com.jumia.jpay.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseBody extends Customer{
    private String state;
    private Country country;
}
