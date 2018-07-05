package com.ewe.kevin210.webapp.customer.web;

import com.ewe.kevin210.webapp.customer.domain.Customer;
import com.ewe.kevin210.webapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final String CUSTOMER_PAGE = "customerPage";
    private static final String CUSTOMER_SITE = "customer/customer";
    private static final Sort DEFAULT_SORT = new Sort(Sort.DEFAULT_DIRECTION, "id");
    private static final String PAGE_REQ_PARAM = "page";

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

}
