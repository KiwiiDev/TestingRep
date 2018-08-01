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
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Optional;



@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final String CUSTOMER_PAGE = "customerPage";
    private static final String CUSTOMER_SITE = "customer/index";
    private static final String CREATE_SITE = "customer/customerFormular";
    private static final Sort DEFAULT_SORT = new Sort(Sort.Direction.DESC, "id");
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
    @GetMapping(value ="/createCustomer")
    public String getNewCustomer (ModelMap model) {
        model.addAttribute("customer", new Customer());
        return CREATE_SITE;
    }

    @PostMapping(value ="/createCustomer")
    public String newCustomerPostRequest(@ModelAttribute Customer customer) throws IOException {

        customerService.createNewCustomer(customer);


        return CUSTOMER_SITE;
    }




}
