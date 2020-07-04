package com.altimetrik.stackoverflow.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
	private Long id;
	@Column(name="ANSWERTEXT")
	private String answerText;
	@Column(name = "SUBMITTED_ON", columnDefinition = "TIMESTAMP")
	private LocalDateTime submittedOn;
	@Column(name="SUBMITTED_BY")
	private String submittedBy;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="commentOnAnswer")
	private List<Comment> comments;
	
	@ManyToOne
    @JoinColumn(name="QUESTION_ID", nullable=false)
	private Question question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	   
}
