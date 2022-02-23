package com.jumia.jpay.service;

import com.jumia.jpay.model.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    List<PhoneNumber> listAll();
    List<PhoneNumber> filterByCountry();
    List<PhoneNumber> filterByState();
}
