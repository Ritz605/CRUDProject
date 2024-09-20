
//called as model of table
package com.Spring.JPA;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tasks {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "assignedBy")
	private String asby;
	
	@Column(name = "assignedTo")
	private String asto;
	
	@CreationTimestamp
	@Column(name = "taskCreated")
	private LocalDateTime tc;
	
	@UpdateTimestamp
	@Column(name = "taskDone")
	private LocalDateTime td;//taskdone

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsby() {
		return asby;
	}

	public void setAsby(String asby) {
		this.asby = asby;
	}

	public String getAsto() {
		return asto;
	}

	public void setAsto(String asto) {
		this.asto = asto;
	}

	public LocalDateTime getTc() {
		return tc;
	}

	public void setTc(LocalDateTime tc) {
		this.tc = tc;
	}

	public LocalDateTime getTd() {
		return td;
	}

	public void setTd(LocalDateTime td) {
		this.td = td;
	}
	
	
	
}
