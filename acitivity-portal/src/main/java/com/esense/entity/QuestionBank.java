package com.esense.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="questions")
@Entity
public class QuestionBank {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id
	private int id;
	

	@Column(name="question")
	private String question;
	
	@OneToOne
	@JoinColumn(name="ans")
	private Options options;
	
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;

	@Column(name="status")
	private Boolean status;
	
	@Column(name="create_date")
	private Timestamp createDate;
	
/*	@Column(name="modify_date")
	private Timestamp modifyDate;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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
/*
	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}*/


	
}
