package com.jumia.jpay.rest;

import com.jumia.jpay.model.Country;
import com.jumia.jpay.model.Customer;
import com.jumia.jpay.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Jumia JPay");
        modelAndView.addObject("msg", "Phone Number Service");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/client-api/phone-numbers/invalid")
    public List<Customer> getInvalid(){
        return phoneNumberService.filterByState();
    }
}
