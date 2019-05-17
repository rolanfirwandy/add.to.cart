package com.btpn.cn.java.project.add.to.cart.dto;

import java.io.Serializable;

public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 6839013551571107671L;

    private Integer customerId;

    private Integer productId;

    private int quantiy;

    public TransactionDto() {}

    public TransactionDto(Integer customerId, Integer productId, int quantiy) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantiy = quantiy;
    }

    public Integer getCustomerId() { return customerId; }

    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) { this.productId = productId; }

    public int getQuantiy() { return quantiy; }

    public void setQuantiy(int quantiy) { this.quantiy = quantiy; }
}
