package com.neosoft.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;
import com.neosoft.service.TransactionService;
import com.neosoft.service.AdminService;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) {
        User userResponse = adminService.saveUser(user);
        return userResponse;
    }
	
	
	@GetMapping(value="/show")
    private List<User> show(){
    	
    	
    	List<User> user = adminService.listAll();
    	return user;
    	
    }
	
	  @GetMapping(value = "/{accountNo}")
	    public User listAccountNo(@PathVariable long accountNo) {
	        User userResponce = adminService.listByAccountNumber(accountNo);

	        return userResponce;
	    }
	  
	  
	  @DeleteMapping(value="/delete/{accountNo}")
	    public String delete(@PathVariable long accountNo) {
	    	
	    	adminService.deleteUser(accountNo);
	    	
	    	return "User deleted";
	    	
	    }
	  
	  
	  @PutMapping(value="deposit/{accountNo},{amount}")
	  public String deposit(@PathVariable long accountNo,@PathVariable BigDecimal amount) {
		  adminService.deposit(accountNo, amount);
		return "Deposited";
		  
	  }


	
	

}
