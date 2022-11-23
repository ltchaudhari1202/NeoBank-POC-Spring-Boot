package com.neosoft.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.neosoft.model.User;

@Component
public interface AdminService {
	
	public User saveUser(User user);

	public List<User> listAll();

	public User listByAccountNumber(long AccountNo);

	public void deleteUser(long accountNo);
	
	public void deposit(long accountNo, BigDecimal amount);
}
