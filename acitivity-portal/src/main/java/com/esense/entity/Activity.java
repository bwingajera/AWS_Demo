package com.esense.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Table(name="activity")
@Entity
public class Activity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id
	private int id;
	
	@Column(name="activity_name")
	private String activityName;
	
	@Column(name="how_to_play")
	private String howToPlay;
	
	@Column(name="hint")
	private String hint;
	
	@OneToOne
	@JoinColumn(name="activity_type")
	private ActivityType activityType;
	
	@Column(name="template")
	private String template;
	
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

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getHowToPlay() {
		return howToPlay;
	}

	public void setHowToPlay(String howToPlay) {
		this.howToPlay = howToPlay;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
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
