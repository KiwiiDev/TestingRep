package com.ewe.kevin210.webapp.customer.web;

import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    public static final String CUSTOMERS = "customers";
    private List<Customer> customers;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getCustomerOverview() {

        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customer(Model model) {
        customers = customerService.getAllCustomers();

        model.addAttribute(CUSTOMERS, customers);

       return "customer/customer";
    }

    @RequestMapping("/i")
    public String index() {
        return "index";
    }

    @ModelAttribute(CUSTOMERS)
    public List<Customer> getCustomers(){
        return customers;
    }
}
