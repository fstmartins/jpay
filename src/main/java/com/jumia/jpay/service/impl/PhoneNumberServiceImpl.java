package com.jumia.jpay.service.impl;

import com.jumia.jpay.model.PhoneNumber;
import com.jumia.jpay.service.PhoneNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    
    @Override
    public List<PhoneNumber> listAll() {
        return null;
    }

    @Override
    public List<PhoneNumber> filterByCountry() {
        return null;
    }

    @Override
    public List<PhoneNumber> filterByState() {
        return null;
    }
}
