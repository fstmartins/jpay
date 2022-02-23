package com.jumia.jpay.rest;

import com.jumia.jpay.model.Customer;
import com.jumia.jpay.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl phoneNumberService;

    @GetMapping("/client-api/phone-numbers")
    public List<Customer> getAllNumbers() {
        return phoneNumberService.listAll();
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("appName", "NAME");
        return "home";
    }
}
