package com.btpn.cn.java.project.add.to.cart.repository;

import com.btpn.cn.java.project.add.to.cart.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByProductName(String name);
}
