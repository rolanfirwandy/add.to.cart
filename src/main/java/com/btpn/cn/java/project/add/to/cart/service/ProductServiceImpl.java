package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Product;
import com.btpn.cn.java.project.add.to.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product saveOrUpdate(Product prod) {
        return productRepository.save(prod);
    }

    @Override
    public void deleteCustomer(Product prod) {
        productRepository.delete(prod);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByProductName(String name) {
        return productRepository.findAllByProductName(name);
    }

    @Override
    public Product findByProductId(Integer prodtomerId) {
        return productRepository.getOne(prodtomerId);
    }
}
