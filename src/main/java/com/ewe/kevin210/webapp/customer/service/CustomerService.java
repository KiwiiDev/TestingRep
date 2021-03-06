package com.ewe.kevin210.webapp.customer.service;


import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.domain.CustomerForm;
import com.ewe.kevin210.webapp.customer.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Service
public class CustomerService {

    public List<Customer> getAllCustomers;
    @Autowired
    private CustomerRepository customerRepository;


    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public void createNewCustomer(Customer customer) throws IOException {
        Customer newCustomer = new Customer(customer);
        customerRepository.save(newCustomer);


    }


}
