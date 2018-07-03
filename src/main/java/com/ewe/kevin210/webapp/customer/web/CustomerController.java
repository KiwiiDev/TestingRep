package com.ewe.kevin210.webapp.customer.web;

import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getCustomerOverview() {
        return customerService.getAllCustomers();
    }
}
