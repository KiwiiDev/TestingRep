package com.ewe.kevin210.webapp.customer.service;


import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Service
public class CustomerService {

    public List<Customer> getAllCustomers;
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){//(Pageable pageable) {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> customersIterable = customerRepository.findAll();
        customersIterable.forEach(customers::add);
        return customers;
    }


}
