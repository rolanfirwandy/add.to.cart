package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Product;
import com.btpn.cn.java.project.add.to.cart.repository.IProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private IProductService productService = new ProductServiceImpl();

    @Test
    public void saveOrUpdate() {
        Product product = new Product(1, "Ciki", 10, "Makanan Ringan", 2000);

        Product productResult = product;

        Mockito.when(productRepository.save(product)).thenReturn(productResult);

        Product productReturnFromMock = productRepository.save(product);

        assertEquals(productResult, productReturnFromMock);
    }

    @Test
    public void deleteCustomer() {
    }

    @Test
    public void findAllProduct() {
    }

    @Test
    public void findAllByProductName() {
    }

    @Test
    public void findByProductId() {
    }
}