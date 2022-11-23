package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {

	public User findByAccountNo(long accountNo);

	public void deleteByAccountNo(long accountNo);

}
