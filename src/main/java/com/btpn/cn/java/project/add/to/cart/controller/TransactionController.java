package com.btpn.cn.java.project.add.to.cart.controller;

import com.btpn.cn.java.project.add.to.cart.domain.Transaction;
import com.btpn.cn.java.project.add.to.cart.dto.TransactionDto;
import com.btpn.cn.java.project.add.to.cart.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/add")
    private Transaction addToCart(@RequestBody TransactionDto transactionDto){
        Transaction trx = transactionService.getOne(transactionDto);

        if (trx == null){
            return transactionService.addToCart(transactionDto);
        }
        return trx;
    }

    @GetMapping("/my/{customerId}")
    private List<Transaction> findAllTransactionByCustomerId (@PathVariable("customerId") Integer customerId){
        return transactionService.findAllTransactionByCustomerId(customerId);
    }

    @PutMapping("/change")
    private Transaction changeQuantity(@RequestBody TransactionDto transactionDto){
        Transaction trx = transactionService.getOne(transactionDto);

        if (trx != null){
            return transactionService.changeQuantity(transactionDto);
        }
        return new Transaction();
    }
}
