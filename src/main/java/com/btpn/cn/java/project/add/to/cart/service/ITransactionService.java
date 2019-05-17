package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Transaction;
import com.btpn.cn.java.project.add.to.cart.dto.TransactionDto;

import java.util.List;

public interface ITransactionService {

    Transaction addToCart(TransactionDto transactionDto);

    Transaction removeFromCart(TransactionDto transactionDto);

    Transaction changeQuantity(TransactionDto transactionDto);

    void removeCartsByCustomerId(Integer customerId);

    List<Transaction> findAllTransaction();

    List<Transaction> findAllTransactionByCustomerId(Integer customerId);

    List<Transaction> findAllTransactionByProductId(Integer productId);

    Transaction getOne(TransactionDto transactionDto);

    Double calculateExitingGrandTotal(Integer customerId);
}
