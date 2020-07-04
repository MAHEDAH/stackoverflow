package com.altimetrik.stackoverflow.uijson;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.altimetrik.stackoverflow.domain.Question;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class QuestionJson {
	
	private Long id;
	private String text;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime submittedOn;
	private String submittedBy;
	
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
	
	public Question toQuestion() {
		Question question = new Question();
		question.setId(this.id);
		question.setSubmittedBy(this.submittedBy);
		question.setSubmittedOn(this.submittedOn);
		question.setText(this.text);
		return question;
	}
	
	public QuestionJson toQuestionJson(Question question) {
		QuestionJson questionJson = new QuestionJson();
		questionJson.setId(question.getId());
		questionJson.setSubmittedBy(question.getSubmittedBy());
		questionJson.setSubmittedOn(question.getSubmittedOn());
		questionJson.setText(question.getText());
		return questionJson;
	}

}
