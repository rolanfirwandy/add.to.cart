package com.btpn.cn.java.project.add.to.cart.repository;

import com.btpn.cn.java.project.add.to.cart.domain.Transaction;
import com.btpn.cn.java.project.add.to.cart.domain.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, TransactionId> {

    List<Transaction> findAllByIdCustomerId(Integer customerId);

    List<Transaction> findAllByIdProductId(Integer productId);

    void deleteAllByIdCustomerId(Integer customerId);

    Transaction findByIdCustomerIdAndIdProductId(Integer customerId, Integer productId);
}
