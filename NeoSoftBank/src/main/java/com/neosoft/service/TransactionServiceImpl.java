package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;
import com.neosoft.repository.TransactionRepository;
import com.neosoft.repository.AdminRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> listAll() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

	@Override
	public Transaction listByTransactionId(int transctionId) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(transctionId).get();
	}

	@Override
	public void deleteTransaction(int transcationId) {
		// TODO Auto-generated method stub
		Transaction transaction=transactionRepository.findById(transcationId).get();
		transactionRepository.delete(transaction);
		
	}
}
