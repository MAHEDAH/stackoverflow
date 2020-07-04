package com.altimetrik.stackoverflow.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
	private Long id;
	@Column(name="COMMENTTEXT")
	private String commentText;
	@Column(name = "SUBMITTED_ON", columnDefinition = "TIMESTAMP")
	private LocalDateTime submittedOn;
	@Column(name="SUBMITTED_BY")
	private String submittedBy;
	
	//@ManyToOne
   // @JoinColumn(name="QUESTION_ID", nullable=true)
	//private Question commentOnQuestion;
	
	@ManyToOne
    @JoinColumn(name="ANSWER_ID", nullable=true)
	private Comment commentOnAnswer;
	
	@OneToOne
	@JoinColumn(name = "PARENT_COMMENT_ID" , nullable = true)
	private Comment childComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
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

	public Comment getCommentOnAnswer() {
		return commentOnAnswer;
	}

	public void setCommentOnAnswer(Comment commentOnAnswer) {
		this.commentOnAnswer = commentOnAnswer;
	}

	public Comment getChildComment() {
		return childComment;
	}

	public void setChildComment(Comment childComment) {
		this.childComment = childComment;
	}
	
	

}
