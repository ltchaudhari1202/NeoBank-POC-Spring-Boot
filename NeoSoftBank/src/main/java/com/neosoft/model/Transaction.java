package com.neosoft.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.neosoft.utility.TransactionType;

@Entity
public class Transaction extends CommonProperties {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int transationId;
	private TransactionType transactionType;
	private BigDecimal transactionAmount;
	//private LocalDateTime date = LocalDateTime.now();
	private BigDecimal balance;
	private long toAccountNumber;

	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

//	public String getTransactionType() {
//		return transactionType;
//	}
//
//	public void setTransactionType(String transactionType) {
//		this.transactionType = transactionType;
//	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

//	public LocalDateTime getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Transaction() {
		super();
	}

	public Transaction(TransactionType transactionType, BigDecimal transactionAmount, 
//			/LocalDateTime date,
			BigDecimal balance, long toAccountNumber) {
		super();
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		//this.date = date;
		this.balance = balance;
		this.toAccountNumber = toAccountNumber;
	}

	@Override
	public String toString() {
		return "Transaction ["
				//+ "transationId=" + transationId 
				+ ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", balance=" + balance + ", toAccountNumber="
				+ toAccountNumber + ", user=" + user + "]";
	}

	

}
