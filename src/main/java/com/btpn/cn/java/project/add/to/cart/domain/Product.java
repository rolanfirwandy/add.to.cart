package com.btpn.cn.java.project.add.to.cart.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 6839094712571107671L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "price", nullable = false)
    private double price;

    public Product(Integer productId, String productName, Integer quantity, String productType, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.productType = productType;
        this.price = price;
    }

    public Product(){}

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) { this.productId = productId; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getProductType() { return productType; }

    public void setProductType(String productType) { this.productType = productType; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("productId=").append(productId);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", productType='").append(productType).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
