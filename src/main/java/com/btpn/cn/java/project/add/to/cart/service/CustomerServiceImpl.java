package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Customer;
import com.btpn.cn.java.project.add.to.cart.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer saveOrUpdate(Customer cus) {
        return customerRepository.save(cus);
    }

    @Override
    public void deleteCustomer(Customer cus) {
        customerRepository.delete(cus);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllByCustomerName(String name) {
        return customerRepository.findAllByCustomerName(name);
    }

    @Override
    public Customer findByCustomerId(Integer customerId) {
        return customerRepository.getOne(customerId);
    }
}
