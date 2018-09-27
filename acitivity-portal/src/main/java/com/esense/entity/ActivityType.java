package com.esense.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="activity_type")
@Entity
public class ActivityType {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="create_date")
	private Timestamp createDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

/*	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name="modify_date")
	private Timestamp modifyDate;*/
}
