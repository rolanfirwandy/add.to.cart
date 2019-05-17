package com.btpn.cn.java.project.add.to.cart.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 6839094751571107671L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cust_id", nullable = false)
    private Integer customerId;

    @Column(name = "cust_name", nullable = false)
    private String customerName;

    @Column(name = "cust_address", nullable = false)
    private String address;

    public Customer(Integer customerId, String customerName, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
    }

    public Customer(){}

    public Integer getCustomerId() { return customerId; }

    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("customerId=").append(customerId);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
