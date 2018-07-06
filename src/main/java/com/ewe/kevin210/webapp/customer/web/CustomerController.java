package com.ewe.kevin210.webapp.customer.web;

import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.domain.CustomerForm;
import com.ewe.kevin210.webapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;



@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final String CUSTOMER_PAGE = "customerPage";
    private static final String CUSTOMER_SITE = "customer/customer";
    private static final String CUSTOMER_CREATE = "createCustomerForm";
    private static final Sort DEFAULT_SORT = new Sort(Sort.DEFAULT_DIRECTION, "id");
    private static final String PAGE_REQ_PARAM = "page";
    private static final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String getCustomerPage(ModelMap model, @RequestParam(value=PAGE_REQ_PARAM, required=false) Optional<Integer> page) {
        model.addAttribute(CUSTOMER_PAGE, getOneCustomerPage(page.orElse(0)));

        return CUSTOMER_SITE;
    }

    private Page<Customer> getOneCustomerPage(int page) {
        PageRequest pageRequest = new PageRequest(page, DEFAULT_PAGE_SIZE, DEFAULT_SORT);

        return customerService.getAllCustomers(pageRequest);
    }
    @RequestMapping(value ="/createCustomer", method = RequestMethod.GET)
    public String getNewCustomerFormular(ModelMap model) {
       // model.addAttribute()
        return CUSTOMER_CREATE;
    }

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String NewCustomer(ModelMap model){
        model.addAttribute(CUSTOMER_CREATE, saveNewCustomer());
        return CUSTOMER_CREATE;
    }

    private Customer saveNewCustomer(){
        Customer customer = new Customer();
        //get all Attributes from the html page and add it to the attributes of the customer object
        return customer;
    }
/*
    @RequestMapping(value ="/createCustomer", method = RequestMethod.GET)
    public String showCreateCustomerPage(ModelMap model) {
        Customer customer = new Customer();
        model.addAttribute(CUSTOMER_CREATE, customer);

        return CUSTOMER_CREATE;
    }*/

}
