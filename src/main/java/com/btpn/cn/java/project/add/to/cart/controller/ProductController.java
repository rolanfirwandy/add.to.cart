package com.btpn.cn.java.project.add.to.cart.controller;

import com.btpn.cn.java.project.add.to.cart.domain.Product;
import com.btpn.cn.java.project.add.to.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/product/add")
    private Product addProduct(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }

    @GetMapping("/product/all")
    private List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @PutMapping("/product/update/{productId}")
    private Product updateProduct (@RequestBody Product product, @PathVariable("productId") Integer productId) {

        Product existProduct = productService.findByProductId(productId);

        if (existProduct != null) {
            product.setProductId(existProduct.getProductId());
            product = productService.saveOrUpdate(product);
        }

        return product;
    }
}
