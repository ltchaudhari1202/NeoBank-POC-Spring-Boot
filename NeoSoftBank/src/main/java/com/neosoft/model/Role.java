package com.neosoft.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.neosoft.utility.RoleType;
@Entity
public class Role extends CommonProperties {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int roleId;
	private RoleType roleType;
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="user_id",nullable = false)
//	private Set<User> user;

	@ManyToMany(mappedBy = "role")
    private Set<User> user = new HashSet();

	


	public RoleType getRoleType() {
		return roleType;
	}


	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}


	public Set<User> getUser() {
		return user;
	}


	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
	



	
	
	
	
	
	
}
