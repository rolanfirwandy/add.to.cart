package com.btpn.cn.java.project.add.to.cart.controller;


import com.btpn.cn.java.project.add.to.cart.domain.Customer;
import com.btpn.cn.java.project.add.to.cart.service.ICustomerService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/add")
    private Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveOrUpdate(customer);
    }

    @GetMapping("/all")
    private List<Customer> getAllCustomer(){
        return customerService.findAllCustomer();
    }

    @PutMapping("/update/{customerId}")
    private Customer updateCustomer (@RequestBody Customer customer, @PathVariable("customerId") Integer customerId){

        Customer updateCustomer = customerService.findByCustomerId(customerId);

        if (updateCustomer != null){
            customer.setCustomerId(updateCustomer.getCustomerId());
            customer = customerService.saveOrUpdate(customer);
        }

        return customer;
    }
}
