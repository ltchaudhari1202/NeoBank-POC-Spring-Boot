package com.neosoft.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//import org.hibernate.envers.Audited;
//import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

public class CommonProperties {
	
	
	@Id
	//@NotAudited
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean isActive = true;
	
	//@NotAudited
	@Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
	
	@Column(name = "modified_date")
    @LastModifiedDate
	private LocalDateTime updatedAt;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	

	
	
	
	
	
	
	




	
	
	
	
	

}