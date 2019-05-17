package com.btpn.cn.java.project.add.to.cart.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 6839093551571107671L;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "transactionId", column = @Column(name = "trans_id", nullable = false)),
            @AttributeOverride(name = "customerId", column = @Column(name = "cust_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "prod_id", nullable = false))
    })
    private TransactionId id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "sub_total", nullable = false)
    private double subTotal;

    @Column(name = "grand_total", nullable = false)
    private double grandTotal;

    public Transaction () {}

    public Transaction(TransactionId id, Date transactionDate, int quantity, double subTotal, double grandTotal) {
        this.id = id;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.grandTotal = grandTotal;
    }

    public TransactionId getId() {
        return id;
    }

    public void setId(TransactionId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Transaction{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", subTotal=").append(subTotal);
        sb.append(", grandTotal=").append(grandTotal);
        sb.append('}');
        return sb.toString();
    }
}
