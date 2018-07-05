package com.ewe.kevin210.webapp.customer.web;

import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

//import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final String CUSTOMERS = "customers";
    private static final String CUSTOMER_SITE = "customer/customer";

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllCustomer(Model model) {
        List<Customer> customers = customerService.getAllCustomers();//(pageable);
        model.addAttribute(CUSTOMERS, customers);


        return CUSTOMER_SITE;
    }




}
