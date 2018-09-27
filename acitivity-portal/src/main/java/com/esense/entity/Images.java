package com.esense.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="images")
@Entity
public class Images {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id
	private int id;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="path")
	private String path;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="create_date")
	private Timestamp createDate;
	
/*	@Column(name="modify_date")
	private Timestamp modifyDate;

*/	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	
}
