package com.neosoft.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.neosoft.service.AccountNumber;
import com.neosoft.utility.RoleType;
@Entity
public class User extends CommonProperties {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private long aadharNo;
	@Column(unique = true)
	private long mobileNo;
	private String emailId;
	@Column(unique = true)
//	@GeneratedValue(generator = "sequence-generator")
//	@GenericGenerator(name = "sequence-generator",
//	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//	parameters = {
//			@Parameter(name = "sequence_name", value = "user_sequence"),
//			@Parameter(name = "initial_value", value = "12020000"),
//			@Parameter(name = "increment_size", value = "1")
//	})
	private long accountNo;
	private BigDecimal balance;
	//private boolean isActive;
	//private LocalDateTime createdAt;
	//private LocalDateTime updatedAt;
	//private RoleType role;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	//@JoinColumn(name = "transactionId",nullable=false)
	private List<Transaction> transaction;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="user_role",
			joinColumns = { @JoinColumn(name = "user_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id") }
			)
	Set<Role> role = new HashSet<>();
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
		AccountNumber ac= AccountNumber.getInstance();
		this.accountNo=ac.getAccountNumber();
		
	}



//	public int getUserId() {
//		return userId;
//	}
//
//
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public long getAadharNo() {
		return aadharNo;
	}



	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

    



	public long getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}



	public BigDecimal getBalance() {
		return balance;
	}



	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}






	public List<Transaction> getTransaction() {
		return transaction;
	}



	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}



	



	public long getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}



	public User(String firstName, String middleName, String lastName, long aadharNo, long mobileNo, String emailId,
			long accountNo, BigDecimal balance, List<Transaction> transaction, Set<Role> role) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.aadharNo = aadharNo;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.accountNo = accountNo;
		this.balance = balance;
		this.transaction = transaction;
		this.role = role;
	}



	public User(String firstName, String middleName, String lastName, long aadharNo, long mobileNo, String emailId,
			long accountNo, BigDecimal balance, Set<Role> role) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.aadharNo = aadharNo;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.accountNo = accountNo;
		this.balance = balance;
		this.role = role;
	}



	



	
	
	
	
	
	
}
