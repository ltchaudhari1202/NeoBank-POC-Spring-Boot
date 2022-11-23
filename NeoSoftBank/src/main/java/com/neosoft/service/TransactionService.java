package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;

public interface TransactionService {
	public Transaction saveTransaction(Transaction transaction);

	public List<Transaction> listAll();

	public Transaction listByTransactionId(int transctionId);

	public void deleteTransaction(int transcationId);

}
