package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Customer;

import java.util.List;

public interface ICustomerService {

    Customer saveOrUpdate(Customer cus);

    void deleteCustomer (Customer cus);

    List<Customer> findAllCustomer();

    List<Customer> findAllByCustomerName(String name);

    Customer findByCustomerId(Integer customerId);
}
