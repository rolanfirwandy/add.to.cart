package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Customer;
import com.btpn.cn.java.project.add.to.cart.domain.Product;

import java.util.List;

public interface IProductService {

    Product saveOrUpdate(Product prod);

    void deleteCustomer (Product prod);

    List<Product> findAllProduct();

    List<Product> findAllByProductName(String name);

    Product findByProductId(Integer productId);

}
