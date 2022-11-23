package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	//public Transaction findByTransactionId(int transactionId);
	
	//public void deleteByTransactionId(int transactionId);
}
