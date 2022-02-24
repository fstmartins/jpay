package com.jumia.jpay.rest;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl phoneNumberService;

    @GetMapping("/client-api/phone-numbers")
    public List<Customer> getAllNumbers(@RequestParam(required = false) Country country) {
        return Objects.isNull(country) ? phoneNumberService.listAll() : phoneNumberService.filterByCountry(country);
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("appName", "NAME");
        return "home";
    }
}
