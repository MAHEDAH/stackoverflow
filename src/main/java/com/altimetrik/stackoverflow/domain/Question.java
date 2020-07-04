package com.altimetrik.stackoverflow.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
	private Long id;
	@Column(name="QUESTIONTEXT")
	private String text;
	@Column(name = "SUBMITTED_ON", columnDefinition = "TIMESTAMP")
	private LocalDateTime submittedOn;
	@Column(name="SUBMITTED_BY")
	private String submittedBy;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	private List<Answer> answers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(LocalDateTime submittedOn) {
		this.submittedOn = submittedOn;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	//private List<Comment> comments;
	

}
