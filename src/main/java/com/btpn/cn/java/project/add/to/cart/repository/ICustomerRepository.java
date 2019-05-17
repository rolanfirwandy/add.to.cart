package com.btpn.cn.java.project.add.to.cart.repository;

import com.btpn.cn.java.project.add.to.cart.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByCustomerName(String name);
}
