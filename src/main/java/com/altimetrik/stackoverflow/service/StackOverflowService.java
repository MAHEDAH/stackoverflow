package com.altimetrik.stackoverflow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.stackoverflow.domain.Question;
import com.altimetrik.stackoverflow.repository.QuestionRepository;

@Service
public class StackOverflowService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public void deleteQuestion(Question question) {
		questionRepository.delete(question);
	}
	
	public Question getQuestion(Long questionId) {
		Optional<Question>  quesObj = questionRepository.findById(questionId);
		return quesObj.get();
	}
	
	public Question updateQuestion(Question question) {
		Question  quesObj = questionRepository.findById(question.getId()).get();
		quesObj.setAnswers(question.getAnswers());
		quesObj.setSubmittedBy(question.getSubmittedBy());
		quesObj.setSubmittedOn(question.getSubmittedOn());
		quesObj.setText(question.getText());
		return questionRepository.save(quesObj);
	}

}
