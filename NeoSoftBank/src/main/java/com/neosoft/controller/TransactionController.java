package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;
import com.neosoft.service.TransactionService;

@RestController
@RequestMapping(value="/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	@PostMapping(value = "/saveTransaction")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        Transaction transactionResponce = transactionService.saveTransaction(transaction);
        return transactionResponce;
    }
	
	
	@GetMapping(value="/show")
    private List<Transaction> show(){
    	
    	
    	List<Transaction> transaction = transactionService.listAll();
    	return transaction;
    	
    }
	
	  @GetMapping(value = "/{transactionId}")
	    public Transaction listTransaction(@PathVariable int transactionId) {
	        Transaction transactionResponce = transactionService.listByTransactionId(transactionId);

	        return transactionResponce;
	    }
	  
	  
	  @DeleteMapping(value="/delete/{transactionId}")
	    public String delete(@PathVariable int transactionId) {
	    	
	    	transactionService.deleteTransaction(transactionId);
	    	
	    	return "Transaction deleted";
	    	
	    }



}
