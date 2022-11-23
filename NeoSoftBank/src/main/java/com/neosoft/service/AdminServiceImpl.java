package com.neosoft.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;
import com.neosoft.repository.AdminRepository;
import com.neosoft.utility.TransactionType;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return adminRepository.save(user);
	}

	public List<User> listAll(){
		return adminRepository.findAll();
	}

	@Override
	public User listByAccountNumber(long AccountNo) {
		// TODO Auto-generated method stub
		return adminRepository.findByAccountNo(AccountNo);
	}

	@Override
	public void deleteUser(long accountNo) {
		// TODO Auto-generated method stub
		//userRepository.deleteByAccountNo(accountNo);
		User user=adminRepository.findByAccountNo(accountNo);
		adminRepository.delete(user);
		
	}

	public void deposit(long accountNo, BigDecimal amount) {
		User user=adminRepository.findByAccountNo(accountNo);
		if(user!=null) {
			BigDecimal newBalance=user.getBalance().add(amount);
			user.setBalance(newBalance);
			Transaction transaction=new Transaction(TransactionType.DEPOSIT,amount, user.getBalance(),accountNo);
			List<Transaction> transactionList= new ArrayList<>();
			transactionList.add(transaction);
			user.setTransaction(transactionList);
			adminRepository.save(user);
			
		}
	}

}
