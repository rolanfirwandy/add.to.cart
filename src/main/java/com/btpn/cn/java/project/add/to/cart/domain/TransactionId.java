package com.btpn.cn.java.project.add.to.cart.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class TransactionId implements Serializable {

    @Column(name = "trans_id", nullable = false, length = 20)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic
    private Timestamp time;

    @Column(name = "cust_id", nullable = false, length = 20)
    private Integer customerId;

    @Column(name = "prod_id", nullable = false, length = 20)
    private Integer productId;

    public TransactionId () {}

    public TransactionId(Timestamp time, Integer customerId, Integer productId) {
        this.time = time;
        this.customerId = customerId;
        this.productId = productId;
    }

    public Timestamp getTime() { return time; }

    public void setTime(Timestamp time) { this.time = time; }

    public Integer getCustomerId() { return customerId; }

    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) { this.productId = productId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionId)) return false;
        TransactionId that = (TransactionId) o;
        return Objects.equals(getTime(), that.getTime()) &&
                Objects.equals(getCustomerId(), that.getCustomerId()) &&
                Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getCustomerId(), getProductId());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TransactionId{");
        sb.append("time=").append(time);
        sb.append(", customerId=").append(customerId);
        sb.append(", productId=").append(productId);
        sb.append('}');
        return sb.toString();
    }
}
