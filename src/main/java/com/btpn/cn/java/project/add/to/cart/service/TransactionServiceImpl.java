package com.btpn.cn.java.project.add.to.cart.service;

import com.btpn.cn.java.project.add.to.cart.domain.Product;
import com.btpn.cn.java.project.add.to.cart.domain.Transaction;
import com.btpn.cn.java.project.add.to.cart.domain.TransactionId;
import com.btpn.cn.java.project.add.to.cart.dto.TransactionDto;
import com.btpn.cn.java.project.add.to.cart.repository.ITransactionRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TransactionServiceImpl implements ITransactionService{

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IProductService productService;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public Transaction addToCart(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        try {
            Product product = productService.findByProductId(transactionDto.getProductId());
            Double subTotal = product.getPrice() * transactionDto.getQuantiy();

            TransactionId id = new TransactionId(new Timestamp(new Date().getTime()), transactionDto.getCustomerId(), transactionDto.getProductId());

            transaction.setId(id);
            transaction.setQuantity(transactionDto.getQuantiy());
            transaction.setSubTotal(subTotal);
            // TODO
            // transaction.setGrandTotal(calculateExitingGrandTotal(transactionDto.getCustomerId()) + subTotal);

            transaction = transactionRepository.save(transaction);

        } catch (Exception e){
            logger.error(e);
            return new Transaction();
        }

        return transaction;
    }

    @Override
    public Transaction removeFromCart(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        try {
            Product product = productService.findByProductId(transactionDto.getProductId());
            Double subTotal = product.getPrice() * transactionDto.getQuantiy();

            TransactionId id = new TransactionId(null, transactionDto.getCustomerId(), transactionDto.getProductId());

            transaction.setId(id);
            transaction.setQuantity(transactionDto.getQuantiy());
            transaction.setSubTotal(subTotal);
            // TODO
            //transaction.setGrandTotal(new Double(1));

            transaction = transactionRepository.save(transaction);

        } catch (Exception e){
            logger.error(e);
            return new Transaction();
        }
        return transaction;
    }

    @Override
    public Transaction changeQuantity(TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.findByIdCustomerIdAndIdProductId(transactionDto.getCustomerId(), transactionDto.getProductId());
        Product product = productService.findByProductId(transactionDto.getProductId());
        Double subTotal = product.getPrice() * transactionDto.getQuantiy();
        Double gap = subTotal - transaction.getSubTotal();
        transaction.setQuantity(transactionDto.getQuantiy());
        transaction.setSubTotal(subTotal);
        // TODO Gap qty lalu tambahkan ke grand
        // transaction.setGrandTotal(calculateExitingGrandTotal(transactionDto.getCustomerId()) + gap);
        return transactionRepository.save(transaction);
    }

    @Override
    public void removeCartsByCustomerId(Integer customerId) {
        transactionRepository.deleteAllByIdCustomerId(customerId);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> findAllTransactionByCustomerId(Integer customerId) {
        return transactionRepository.findAllByIdCustomerId(customerId);
    }

    @Override
    public List<Transaction> findAllTransactionByProductId(Integer productId) {
        return transactionRepository.findAllByIdProductId(productId);
    }

    @Override
    public Transaction getOne(TransactionDto transactionDto) {
        Transaction trx = new Transaction();
        try {
            trx = transactionRepository.findByIdCustomerIdAndIdProductId(transactionDto.getCustomerId(), transactionDto.getProductId());
        } catch (Exception e){
            logger.error(e);
            return trx;
        }
        return trx;
    }

    @Override
    public Double calculateExitingGrandTotal(Integer customerId) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        Double grandTotal = new Double(0);
        try {
            transactions = transactionRepository.findAllByIdCustomerId(customerId);
            for (Transaction trx : transactions){
                grandTotal =+ trx.getSubTotal();
            }

        } catch (Exception e ){
            logger.error(e);
            return grandTotal;
        }

        return grandTotal;
    }
}
