package com.jumia.jpay.rest;

import com.jumia.jpay.model.PhoneNumber;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class PhoneNumbersController {

    @GetMapping("/client-api/phone-numbers")
    public List<PhoneNumber> getAllNumbers() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhone("23412341234");
        phoneNumber.setName("Name");
        phoneNumber.setId(1);
        return Collections.singletonList(phoneNumber);
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("appName", "NAME");
        return "home";
    }
}
